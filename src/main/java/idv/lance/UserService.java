package idv.lance;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    /**
     * get user with length of name size
     * 
     * @param length
     * @return
     */
    public List<User> getUserWithNameLengthGreaterThan(int length) {
        return DataProvider.getUsers().stream()
                .filter(u -> u.getName().length() > length)
                .collect(Collectors.toList());
    }

    public Integer sumOfAge() {
        return DataProvider.getUsers().stream()
                .map(User::getAge)
                .reduce(0, Integer::sum);
    }
}