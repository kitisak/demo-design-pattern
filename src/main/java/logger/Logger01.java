package logger;

interface Filter {
    boolean accept(String message);
}

public interface Logger01 {
    void log(String message);

    static void main(String... args) {
        Logger01 logger = message -> System.out.println(message);

        logger.log("Hello");
    }

}
