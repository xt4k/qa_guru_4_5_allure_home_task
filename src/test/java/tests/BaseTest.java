package tests;

import org.junit.jupiter.api.BeforeAll;
import po.BasePageObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.startMaximized;
import static java.lang.System.setProperty;

public class BaseTest {
    public final static String GITHUB_REPO_NAME = "qa_guru_4_5_allure_home_task";
    public final static String GITHUB_OWNER = "xt4k";
    public final static String BaseURI = "https://api.github.com";
    final static String BASE_URL = "https://github.com";
    static ApiOps apiOps;
    static BasePageObject pageObject = new BasePageObject();

    @BeforeAll
    static void setup() {
        startMaximized = true;
        apiOps = new ApiOps();
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/properties/common.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setProps(properties);
    }

    private static void setProps(Properties properties) {
        properties.forEach((key, value) -> setProperty((String) key, (String) value));
    }
}