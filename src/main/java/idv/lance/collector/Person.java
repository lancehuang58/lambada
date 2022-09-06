package idv.lance.collector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Person {
    private String name;
    private Integer age;
}
