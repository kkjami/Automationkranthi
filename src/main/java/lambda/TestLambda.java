package lambda;

public class TestLambda {
    static Addition addLambda = (i, j) -> i + j;

    public static void main(String[] args) {
        System.out.println(addLambda.add(1, 2));
    }
}