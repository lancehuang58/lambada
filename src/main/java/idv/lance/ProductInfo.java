package idv.lance;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class ProductInfo {

    @Singular
    private List<String> parts;

    private String name;
}
