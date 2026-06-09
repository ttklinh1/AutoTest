package dataproviders;

import models.LoginData;
import org.testng.annotations.DataProvider;
import utils.JsonDataReader;

import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "loginUsers")
    public Object[][] loginUsers() {

        List<LoginData> users =
                JsonDataReader.getLoginUsers();

        Object[][] data =
                new Object[users.size()][1];

        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }

        return data;
    }
}