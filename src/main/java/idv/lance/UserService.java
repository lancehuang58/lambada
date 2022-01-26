package idv.lance;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sound.sampled.SourceDataLine;

import lombok.var;

import static idv.lance.DataProvider.getUsers;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

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

    public String getMaxAgeName() {
        return getUsers().stream()
                .collect(
                        collectingAndThen(
                                maxBy(comparing(User::getAge)),
                                user -> user.map(User::getName).orElse("")));
    }

    static Collector<User, User, Integer> maxAgeUser = collectingAndThen(
            maxBy(comparing(User::getAge)),
            user -> user.map(User::getAge).orElse(1));

    public Map<String, Integer> getMaxAgeWithSameNameUser() {
        return getUsers()
                .stream()
                .collect(groupingBy(User::getName, maxAgeUser));
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

    public Map<Boolean, List<User>> showAgeMapping() {
        return getUsers().stream()
                .collect(partitioningBy(user -> user.getAge() % 2 == 0));
    }

    public Map<String, Set<Integer>> showUserGroupingByName() {
        return getUsers()
                .stream()
                .collect(groupingBy(User::getName,
                        mapping(User::getAge, toSet())));
    }

    public Map<String, Long> showUserNameCounting() {
        return getUsers().stream().collect(groupingBy(User::getName, counting()));
    }

    public Map<String, Integer> showUserNameCountingInteger() {
        return getUsers().stream()
                .collect(
                        groupingBy(User::getName,
                                collectingAndThen(
                                        counting(), Long::intValue)));
    }
}
