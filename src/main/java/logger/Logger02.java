package logger;

import java.util.Objects;
import java.util.function.Predicate;

public interface Logger02 {
    void log(String message);

    default Logger02 filter(Predicate<String> filter) {
        Objects.requireNonNull(filter);
        return message -> {
            if(filter.test(message)) {
                log(message);
            }
        };
    }

    public static void main(String... args) {
        Logger02 logger02 = message -> System.out.println(message);
        Logger02 filterLogger = logger02.filter(message -> message.startsWith("Test"));

        logger02.log("Hello 1");
        filterLogger.log("Hello 2");
        filterLogger.log("Test Hello 3");

    }

}
