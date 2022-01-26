package idv.lance;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class DataProvider {

    private DataProvider() {

    }

    public static List<User> getUsers() {
        try {
            String data = Files.readString(
                    Paths.get(Thread.currentThread().getContextClassLoader().getResource("data1.json").toURI()));
            return JSON.parseArray(data, User.class);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
