package idv.lance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@Slf4j
class UserServiceTest {
  UserService userService = new UserService();

  @Test
  void test_join_name() {
    String joinedUserNamesUppercase = userService.getJoinedUserNamesUppercase(30);
    log.info("names {}", joinedUserNamesUppercase);
    Assertions.assertNotNull(joinedUserNamesUppercase);
  }

  @Test
  void show_age_mapping() {
    userService.showAgeMapping();
  }

  @Test
  void show_name_grouping() {
    userService.showUserGroupingByName();
  }
}
