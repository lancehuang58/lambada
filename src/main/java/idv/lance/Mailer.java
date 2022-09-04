package idv.lance;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Mailer {
    public static void print(String msg) {
        log.info("{}", msg);
    }

    public Mailer from(String addr) {
        print("from");
        return this;
    }

    public Mailer to(String addr) {
        print("to");
        return this;
    }


    public Mailer subject(String line) {
        print("subject");
        return this;
    }

    public Mailer body(String msg) {
        print("body");
        return this;
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        print("sending...");
    }

    public static void main(String[] args) {
        Mailer.send(mailer -> mailer
                        .from("builder@agildeveloper.com")
                        .to("lancehuang@gmail.com")
                        .subject("your code sucks.")
                        .body(".... here you go...."));
    }
}
