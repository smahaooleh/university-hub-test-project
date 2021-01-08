package osmaha.universityhub.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osmaha.universityhub.repository.RepositoryException;
import osmaha.universityhub.service.DepartmentStatisticsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class DepartmentAverageSalaryCommandHandler implements CommandHandler {

    private String matchedPattern = "^Show the average salary for the department [\\w+ ]*";
    private String replacePattern = "Show the average salary for the department ";

    @Autowired
    DepartmentStatisticsService departmentStatisticsService;

    @Override
    public boolean isMatched(String commandLine) {
        return Pattern.matches(matchedPattern, commandLine);
    }

    @Override
    public List<String> handle(String commandLine) throws Exception {
        String[] arguments = commandLine.replaceAll(replacePattern, "").split("\\s+");

        try{
            validateArguments(arguments);

            return departmentStatisticsService.getAverageSalaryForDepartment(arguments[0]);

        } catch (CommandLineHandlerException | RepositoryException e) {
            return new ArrayList<>(Arrays.asList(e.getMessage()));
        }
    }

    private void validateArguments(String[] arguments) throws CommandLineHandlerException {
        if(arguments.length ==0 || (arguments.length == 1 && arguments[0].equals(""))) {
            throw new CommandLineHandlerException("Error: No argument for command 'Show the average salary for the department [department_name]'");
        }
        if(arguments.length > 1) {
            throw new CommandLineHandlerException("Error: More than 1 argument for command 'Show the average salary for the department [department_name]'");
        }
    }
}
