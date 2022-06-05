package idv.lance;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
    private Department dept;

    @Builder
    public Employee(int age, String name, String firstName, Department department) {
        super(age, name, firstName);
        this.dept = department;
    }
}
