package idv.lance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

class CollectorTest {

    UserService userService = new UserService();

    @Test
    void reduce_operation_sum() {
        Assertions.assertEquals(449, userService.sumOfAge());
    }

//  @Test
//  void reduce_by_three_params() {
//
//    List<String> collection =
//        userService.getUserWithNameLengthGreaterThan(10).stream()
//            .map(User::getName)
//            .reduce(
//                new ArrayList<>(),
//                (names, name) -> {
//                  names.add(name);
//                  return names;
//                },
//                (names1, names2) -> {
//                  names1.addAll(names2);
//                  return names1;
//                });
//    Assertions.assertTrue(!collection.isEmpty());
//  }

    @Test
    void reduce_by_collectors() {
        List<String> names =
                userService.getUserWithNameLengthGreaterThan(10).stream()
                        .map(User::getName)
                        .collect(toList());
        Assertions.assertTrue(names.isEmpty());
    }

    @Test
    void filter_age_greater_than_30() {
        List<User> users = userService.getUserAgeGreaterThan(30);
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    void map_entity_to_map() {
        Map<String, Integer> userAgeInfo = userService.getUserAgeInfo();
        Assertions.assertFalse(userAgeInfo.isEmpty());
    }

}
