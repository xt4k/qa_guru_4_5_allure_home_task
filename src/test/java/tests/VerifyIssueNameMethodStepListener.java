package tests;

import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pojo.Issue;

import java.util.List;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Github repo functional tests")
@Feature("Issues operations")
@Story("Method_Step-style markup")
public class VerifyIssueNameMethodStepListener extends BaseTest {

    @Test
    @Tags({ @Tag("web"), @Tag("reusable"), @Tag("method-step"), @Tag("listener") })
    @Link(name = "BASE_URL", value = BASE_URL)
    @DisplayName("Test 4.2 Check Github repository issues name. Method_Step-style markup + Listener.")
    @Owner("aqa")
    @Severity(CRITICAL)
    void compareGithubRepoIssueName() {
        addListener("allure", new AllureSelenide());

        parameter("Repo name", GITHUB_REPO_NAME);
        parameter("Repo owner", GITHUB_OWNER);
        parameter("Base_Url", BASE_URL);

        pageObject.openBaseUrl(BASE_URL, GITHUB_OWNER, GITHUB_REPO_NAME)
                .openIssuesPage();
        List<Issue> issueList = apiOps.getIssueListStep();
        for (Issue issue : issueList)
            pageObject.compareIssueName(issue);
    }
}