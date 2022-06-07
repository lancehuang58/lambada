package idv.lance;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
    private Department dept;

    @Builder
    public Employee(int age, String name, String firstName, @NonNull Department department) {
        super(0, age, name, firstName);
        this.dept = department;
    }
}
