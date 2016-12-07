package logger;

import java.util.Objects;

interface Filter04 {
    boolean accept(String message);
}

public interface Logger04 {
    void log(String message);

    public static void main(String... args) {
        Logger04 logger = message -> System.out.println(message);
        Filter04 filter = message -> message.startsWith("Test");
        FilterLogger4 filterLogger = new FilterLogger4(logger, filter);

        logger.log("Hello 1");
        filterLogger.log("Hello 2");
        filterLogger.log("Test Hello 3");
    }

}

class FilterLogger4 implements Logger04 {
    private final Logger04 logger;
    private final Filter04 filter;

    public FilterLogger4(Logger04 logger, Filter04 filter) {
        this.logger = Objects.requireNonNull(logger);
        this.filter = Objects.requireNonNull(filter);
    }

    public void log(String message) {
        if (filter.accept(message)) {
            logger.log(message);
        }
    }
}