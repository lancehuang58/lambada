package idv.lance;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static idv.lance.DataProvider.getUsers;
import static java.util.Comparator.comparing;
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
                .collect(toList());
    }

    public Integer sumOfAge() {
        return getUsers().stream().map(User::getAge).reduce(0, Integer::sum);
    }

    public String getMaxAgeName() {
        return getUsers().stream()
                .collect(
                        collectingAndThen(
                                maxBy(comparing(User::getAge)), user -> user.map(User::getName).orElse("")));
    }

    public Map<String, Integer> getMaxAgeWithSameNameUser() {
        return getUsers().stream()
                .collect(
                        groupingBy(
                                User::getName,
                                collectingAndThen(
                                        maxBy(comparing(User::getAge)), user -> user.map(User::getAge).orElse(1))));
    }

    public List<User> getUserAgeGreaterThan(int i) {
        return getUsers().stream().filter(user -> user.getAge() > i).collect(toList());
    }

    public Map<String, Integer> getUserAgeInfo() {
        return getUsers().stream().collect(toMap(User::getName, User::getAge, (a, b) -> a));
    }

    public List<Integer> getImmutableAgeList() {
        return getUsers().stream().map(User::getAge).collect(toUnmodifiableList());
    }

    public String getJoinedUserNamesUppercase(int age) {
        return getUsers().stream()
                .filter(user -> user.getAge() > age)
                .map(User::getName)
                .map(String::toUpperCase)
                .collect(joining(","));
    }

    public Map<Boolean, List<User>> showAgeMapping() {
        return getUsers().stream().collect(partitioningBy(user -> user.getAge() % 2 == 0));
    }

    public Map<String, Set<Integer>> showUserGroupingByName() {
        return getUsers().stream().collect(groupingBy(User::getName, mapping(User::getAge, toSet())));
    }

    public Map<String, Long> showUserNameCounting() {
        return getUsers().stream().collect(groupingBy(User::getName, counting()));
    }

    public Map<String, Integer> showUserNameCountingInteger() {
        return getUsers().stream()
                .collect(groupingBy(User::getName, collectingAndThen(counting(), Long::intValue)));
    }

    public void getFlatMappingNames() {
        var i =
                getUsers().stream()
                        .collect(
                                groupingBy(
                                        User::getAge,
                                        mapping(
                                                user -> user.getName().toUpperCase(),
                                                flatMapping(name -> Stream.of(name.split("")), toSet()))));
        System.out.println(i);
    }
}
