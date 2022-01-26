package idv.lance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

class CollectorTest {

  UserService userService = new UserService();

  @Test
  void reduce_operation_sum() {
    Assertions.assertEquals(449, userService.sumOfAge());
  }

  @Test
  void reduce_by_three_params() {

    List<String> collection =
        userService.getUserWithNameLengthGreaterThan(10).stream()
            .map(User::getName)
            .reduce(
                new ArrayList<String>(),
                (names, name) -> {
                  names.add(name);
                  return names;
                },
                (names1, names2) -> {
                  names1.addAll(names2);
                  return names1;
                });
    Assertions.assertTrue(!collection.isEmpty());
  }

  @Test
  void reduce_by_collectors() {
    List<String> names =
        userService.getUserWithNameLengthGreaterThan(10).stream()
            .map(User::getName)
            .collect(toList());
    Assertions.assertFalse(names.isEmpty());
  }
}
