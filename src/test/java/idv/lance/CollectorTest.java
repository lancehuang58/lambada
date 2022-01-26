package idv.lance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static idv.lance.DataProvider.getUsers;

class CollectorTest {

  @Test
  void reduce_operation_sum() {
    Integer reduce = getUsers().stream().map(User::getN).reduce(0, Integer::sum);
    Assertions.assertEquals(55, reduce);
  }

  @Test
  void reduce_to_string() {
    List<User> nameLenGreaterThan10 = getUsers().stream().filter(p -> p.getName().length() > 10)
        .collect(Collectors.toList());

    List<String> collection = nameLenGreaterThan10.stream()
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
}
