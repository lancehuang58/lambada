package idv.lance;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static idv.lance.DataProvider.getUsers;

class CollectorDemo {

  @Test
  void reduce_operation_sum() {
    Integer reduce = getUsers().stream().map(User::getN).reduce(0, Integer::sum);
    System.out.println(reduce);
  }

  void reduce_op_2() {
    getUsers();
  }
}
