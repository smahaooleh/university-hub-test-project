package osmaha.universityhub.handler;

import java.util.List;

public interface CommandHandler {

    boolean isMatched(String commandLine);

    List<String> handle(String commandLine) throws Exception;

}
