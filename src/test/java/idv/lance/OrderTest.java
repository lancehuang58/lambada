package idv.lance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@Slf4j
class OrderTest {

    @Test
    void test_order_build() {
        Order order = Order.builder().id(UUID.randomUUID().toString()).name("spec").build();

        log.info("order {}", order);
    }
}
