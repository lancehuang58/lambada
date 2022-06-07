package idv.lance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ProductInfoServiceTest {
    ProductInfoService service = new ProductInfoService();

    @Test
    void test_get_info() {
        ProductInfo info = service.getInfo();
        log.info("info {}", info);
    }
}
