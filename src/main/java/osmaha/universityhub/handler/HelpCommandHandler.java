package osmaha.universityhub.handler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class HelpCommandHandler  implements CommandHandler {

    private String matchedPattern = "help";

    @Override
    public boolean isMatched(String commandLine) {
        return Pattern.matches(matchedPattern, commandLine);
    }

    @Override
    public List<String> handle(String commandLine) throws Exception {
        return prepareHelpInfo();
    }

    private List<String> prepareHelpInfo(){
        List<String> helpInfo = new ArrayList<>();

        helpInfo.add("---------------------------------------------------------------------");
        helpInfo.add("Test Spring Boot Java project for BotsCrew has following commands:");
        helpInfo.add("•get the head of department");
        helpInfo.add("\t'Who is head of department [department_name]'");
        helpInfo.add("•show statistics of department");
        helpInfo.add("\t'Show [department_name] statistics'");
        helpInfo.add("•calculate average salary for the department");
        helpInfo.add("\t'Show the average salary for the department [department_name]'");
        helpInfo.add("•calculate count of employee for department");
        helpInfo.add("\t'Show count of employee for [department_name]'");
        helpInfo.add("•search by template");
        helpInfo.add("\t'Global search by [search_template]'");
        helpInfo.add("---------------------------------------------------------------------");

        return helpInfo;
    }
}
