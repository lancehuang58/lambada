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
    var i = userService.showAgeMapping();
    log.info("age mapping {}", i);
    Assertions.assertFalse(i.isEmpty());
  }

  @Test
  void show_name_grouping() {
    var i = userService.showUserGroupingByName();
    log.info("name grouping {}", i);
    Assertions.assertFalse(i.isEmpty());
  }

  @Test
  void test_show_name_counting() {
    var i = userService.showUserNameCounting();
    log.info("user name counting {}", i);
    Assertions.assertFalse(i.isEmpty());
  }

  @Test
  void test_countingAndThen() {
    var i = userService.showUserNameCountingInteger();
    log.info("user name counting and then (convert to int) {}", i);
    Assertions.assertFalse(i.isEmpty());
  }

  @Test
  void test_max_age_user() {
    var i = userService.getMaxAgeName();
    log.info("max age user group {}", i);

  }

  @Test
  void test_getMaxAgeWithSameNameUser() {
    var i = userService.getMaxAgeWithSameNameUser();
    log.info("max age user {}", i);
  }

  @Test
  void test_flat_mapping(){
    userService.getFlatMappingNames();
  }
}
