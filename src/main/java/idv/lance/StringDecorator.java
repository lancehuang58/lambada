package idv.lance;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StringDecorator {

    static UnaryOperator<String> touppercase = String::toUpperCase;
    static UnaryOperator<String> appendPrefix = s -> "[" + s;
    static UnaryOperator<String> appendSubfix = s -> s + "]";
    Function<String, String> function;

    public StringDecorator(Function<String, String>... filters) {
        function = Arrays.stream(filters).reduce(UnaryOperator.identity(), Function::andThen);
    }

    public static void main(String[] args) {
        String lance =
                new StringDecorator(appendPrefix, appendSubfix, touppercase).applyToString("Lance");
        System.out.println(lance);
    }

    public String applyToString(String s) {
        return function.apply(s);
    }
}
