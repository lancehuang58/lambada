package idv.lance;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Decorator2 {
    public static void printSnap(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printSnap(new Camera(color -> color));
        printSnap(new Camera(Color::brighter));
        printSnap(new Camera(Color::brighter, Color::darker));
    }
}

class Camera {

    private Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    private void setFilters(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                //.reduce(color -> color, (theFilters, aFilter) -> theFilters.andThen(aFilter)
                .reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }
}