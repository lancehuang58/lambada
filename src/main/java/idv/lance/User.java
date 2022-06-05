package idv.lance;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private int age;
    private String name;
    @EqualsAndHashCode.Exclude
    private String firstName;
}
