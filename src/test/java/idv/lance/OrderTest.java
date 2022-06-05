package idv.lance;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderTest {

  @Test
  public void test_order_build() {
    Order order = Order.builder().id(UUID.randomUUID().toString()).name("spec").build();

    log.info("order {}", order);
  }
}
