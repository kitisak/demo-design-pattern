package logger;

import java.util.Objects;

interface Filter03 {
    boolean accept(String message);
}

public interface Logger03 {
    void log(String message);

    public static void main(String... args) {
        Logger03 logger = message -> System.out.println(message);
        FilterLogger filterLogger = new TestLogger(logger);

        logger.log("Hello 1");
        filterLogger.log("Hello 2");
        filterLogger.log("Test Hello 3");
    }

}

abstract class FilterLogger implements Logger03, Filter03 {
    private final Logger03 logger;

    public FilterLogger(Logger03 logger) {
        this.logger = Objects.requireNonNull(logger);
    }

    public abstract boolean accept(String message);

    @Override
    public void log(String message) {
        if(accept(message)) {
            logger.log(message);
        }
    }
}

class TestLogger extends FilterLogger {

    public TestLogger(Logger03 logger) {
        super(logger);
    }

    @Override
    public boolean accept(String message) {
        return message.startsWith("Test");
    }
}
