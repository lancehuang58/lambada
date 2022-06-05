package idv.lance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductInfoServiceTest {
    ProductInfoService service = new ProductInfoService();

    @BeforeEach
    public void init() {
        ;
    }

    @Test
    public void test_get_info() {
        ProductInfo info = service.getInfo();
        log.info("info {}", info);
    }
}
