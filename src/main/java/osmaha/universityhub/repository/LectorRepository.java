package osmaha.universityhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osmaha.universityhub.domain.Degree;
import osmaha.universityhub.domain.Department;
import osmaha.universityhub.domain.Lector;

import java.util.List;
import java.util.Set;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findByFirstNameContainingOrLastNameContainingIgnoreCase(String templateForFirstName, String templateForLastName);

    List<Lector> findByDepartment(Department department);

    List<Lector> findByDepartmentAndDegrees(Department department, Degree degree);
}
