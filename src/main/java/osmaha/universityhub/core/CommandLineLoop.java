package osmaha.universityhub.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import osmaha.universityhub.handler.CommandHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CommandLineLoop implements CommandLineRunner {

    private boolean running;
    private BufferedReader in;
    private BufferedWriter out;

    @Autowired
    private List<CommandHandler> commandHandlers;

    @Override
    public void run(String... args) throws Exception {

        running = true;

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

            write(getStartInfo());
            while (running) {
                String commandLine = in.readLine();

                if (commandLine.equals("exit")) {
                    write(getExitInfo());
                    running = false;
                    continue;
                }

                if (commandLine.length() == 0) {
                    continue;
                }

                write(process(commandLine));
            }
        } catch (Exception e) {
            throw new CommandLineLoopException("CommandLineLoop has been terminated with exception", e.getCause());
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    private List<String> process(String commandLine) throws Exception {
        for (CommandHandler handler : commandHandlers) {
            if (handler.isMatched(commandLine)) {
                return handler.handle(commandLine);
            }
        }

        return getUnknownCommandInfo();
    }

    private void write(List<String> lines) throws IOException {
        for (String line : lines) {
            out.write(line + "\n");
        }
        out.write("\n");
        out.flush();
    }

    private List<String> getStartInfo() {
        List<String> startInfo = new ArrayList<>(Arrays.asList("University Hub has been load", "Try to enter a command or use 'help' to get more information about commands"));
        return startInfo;
    }

    private List<String> getUnknownCommandInfo() {
        List<String> unknownCommandInfo = new ArrayList<>(Arrays.asList("This command is not registered.", "Try again or use 'help' to get more information about commands"));
        return unknownCommandInfo;
    }

    private List<String> getExitInfo() {
        List<String> exitInfo = new ArrayList<>(Arrays.asList("University Hub is closing"));
        return exitInfo;
    }
}