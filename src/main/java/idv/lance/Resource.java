package idv.lance;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Resource {

    private Resource() {
        log.info("created");
    }

    public void op1() {
        log.info("op1");
    }

    public void op2() {
        log.info("op2");
    }

    private void close() {
        log.info("clean up");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }


    public static void main(String[] args) {
        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });

    }

    //easy to forget close
    //exception
    private static void normalCase() {
        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        resource.close();
    }
}
