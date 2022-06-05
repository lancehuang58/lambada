package idv.lance;

public class ProductInfoService {

    public ProductInfo getInfo() {
        return ProductInfo.builder()
                .name("iron man")
                .part("Helemt").part("belt")
                .build();
    }
}
