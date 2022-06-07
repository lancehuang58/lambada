package idv.lance;

import lombok.NonNull;
import lombok.ToString;
import lombok.With;

@ToString
public class Point {
    @With
    private final Integer x;
    @With
    private final Integer y;

    public Point(@NonNull Integer x, @NonNull Integer y) {
        this.x = x;
        this.y = y;
    }
}
