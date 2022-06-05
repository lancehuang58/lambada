package idv.lance;

import lombok.Builder;
import lombok.Data;

@Data
public class Order {

    private String id;
    private String name;
    private Long createTime;

    @Builder
    public Order(String id, String name) {
        this.id = id;
        this.name = name;
        this.createTime = System.currentTimeMillis();
    }

}
