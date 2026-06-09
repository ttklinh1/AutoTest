package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonDataReader {

    public static List<LoginData> getLoginUsers() {

        List<LoginData> users = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root =
                    mapper.readTree(
                            new File("src/test/resources/testdata/loginData.json"));

            for (JsonNode node : root.get("users")) {

                LoginData data =
                        mapper.treeToValue(node, LoginData.class);

                users.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}