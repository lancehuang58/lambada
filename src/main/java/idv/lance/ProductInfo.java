package idv.lance;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ProductInfo {

    @Singular
    private List<String> parts;

    private String name;
}
