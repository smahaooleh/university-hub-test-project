package osmaha.universityhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osmaha.universityhub.domain.Degree;
import osmaha.universityhub.domain.Department;
import osmaha.universityhub.domain.Lector;
import osmaha.universityhub.repository.DegreeRepository;
import osmaha.universityhub.repository.DepartmentRepository;
import osmaha.universityhub.repository.LectorRepository;
import osmaha.universityhub.repository.RepositoryException;

import java.util.*;

@Service
public class DepartmentStatisticsService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private LectorRepository lectorRepository;


    public List<String> getNumberOfEmployeesForDepartment(String departmentName) throws Exception {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            throw new RepositoryException("Department is not found");
        }

        List<String> result = new ArrayList<>();

        long numberOfEmployee = lectorRepository.findByDepartment(department.get())
                .stream().count();

        String lineOutput = "" + numberOfEmployee;
        result.add(lineOutput);

        return result;
    }

    public List<String> getNumberOfEmployeesByDegreeForDepartment(String departmentName) throws Exception {

        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            throw new RepositoryException("Department is not found");
        }

        List<String> result = new ArrayList<>();

        List<Degree> degrees = degreeRepository.findAll();

        for (Degree degree : degrees) {
            long numberOfEmployee = lectorRepository.findByDepartmentAndDegrees(department.get(), degree)
                    .stream().count();

            String lineOutput = degree.getTitle().name().toLowerCase() + " - " + numberOfEmployee;
            result.add(lineOutput);
        }

        return result;
    }

    public List<String> getDepartmentHead(String departmentName) throws Exception {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            throw new RepositoryException("Department is not found");
        }

        List<String> result = new ArrayList<>();

        String departmentHeadName = department.get().getHead().getFirstName() + " " + department.get().getHead().getLastName();

        String lineOutput = "Head of " + department.get().getName() + " department is " + departmentHeadName;
        result.add(lineOutput);
        return result;
    }

    public List<String> getAverageSalaryForDepartment(String departmentName) throws Exception {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            throw new RepositoryException("Department is not found");
        }

        List<String> result = new ArrayList<>();

        List<Lector> lectors = lectorRepository.findByDepartment(department.get());

        OptionalDouble averageSalary = lectors.stream().mapToDouble((lector) -> lector.getSalary()).average();


        String lineOutput = "The average salary of " + department.get().getName() + " is " + averageSalary.orElse(0.0);
        result.add(lineOutput);
        return result;
    }

}
