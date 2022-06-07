package idv.lance;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Getter
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }
}
