@FunctionalInterface
interface Calculator {
    int apply(int value1, int value2);

    public static void main(String... args) {
        Calculator add = (x, y) -> x + y;
        Calculator minus = (x, y) -> x - y;
        Calculator multiply = (x, y) -> x * y;

        System.out.println(add.apply(1, 2));
        System.out.println(minus.apply(2, 1));
        System.out.println(multiply.apply(1, 2));
    }
}


