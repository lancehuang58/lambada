package idv.lance;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private int index;
    private int age;
    private String name;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String firstName;
}
