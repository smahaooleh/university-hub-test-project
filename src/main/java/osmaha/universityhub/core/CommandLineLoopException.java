package osmaha.universityhub.core;

public class CommandLineLoopException extends Exception {
    public CommandLineLoopException() {
    }

    public CommandLineLoopException(String message) {
        super(message);
    }

    public CommandLineLoopException(String message, Throwable cause) {
        super(message, cause);
    }
}
