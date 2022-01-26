package idv.lance;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.var;

import static idv.lance.DataProvider.getUsers;
import static java.util.stream.Collectors.*;

public class UserService {

    /**
     * get user with length of name size
     *
     * @param length
     * @return
     */
    public List<User> getUserWithNameLengthGreaterThan(int length) {
        return getUsers().stream()
                .filter(u -> u.getName().length() > length)
                .collect(Collectors.toList());
    }

    public Integer sumOfAge() {
        return getUsers().stream().map(User::getAge).reduce(0, Integer::sum);
    }

    public List<User> getUserAgeGreaterThan(int i) {
        return getUsers().stream().filter(user -> user.getAge() > i).collect(Collectors.toList());
    }

    public Map<String, Integer> getUserAgeInfo() {
        return getUsers().stream().collect(Collectors.toMap(User::getName, User::getAge));
    }

    public List<Integer> getImmutableAgeList() {
        return getUsers().stream().map(User::getAge).collect(Collectors.toUnmodifiableList());
    }

    public String getJoinedUserNamesUppercase(int age) {
        return getUsers().stream()
                .filter(user -> user.getAge() > age)
                .map(User::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }

    public void showAgeMapping() {
        Map<Boolean, List<User>> ageMapping = getUsers().stream()
                .collect(partitioningBy(user -> user.getAge() % 2 == 0));
        System.out.println(ageMapping.get(true));
        System.out.println(ageMapping.get(false));
    }

    public void showUserGroupingByName() {
        Map<String, Set<Integer>> usersGropingByName = getUsers()
                .stream()
                .collect(groupingBy(User::getName,
                        mapping(User::getAge, toSet())));
        System.out.println(usersGropingByName);
    }

    public void showUserNameCounting() {
        var i = getUsers().stream().collect(groupingBy(User::getName, counting()));
        System.out.println(i);
    }
}
