package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pojo.Issue;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static java.lang.String.format;

@Feature("Functional tests")
@Story("Issues operations")
public class VerifyIssueNameLambada extends BaseTest {

    @Test
    @Tags({ @Tag("web"), @Tag("important") })
    @Link(name = "BASE_URL", value = BASE_URL)
    @DisplayName("2. Check Github repository issues name (Lambda-style markup)")
    @Owner("yuriy")
    @Severity(CRITICAL)
    void compareGithubRepoIssueName() {
        parameter("Repo name", GITHUB_REPO_NAME);
        parameter("Repo owner", GITHUB_OWNER);
        parameter("Base_Url", BASE_URL);

        step(format("Open Github repository %s", GITHUB_REPO_NAME), () -> {
            open(format("%s/%s/%s", BASE_URL, GITHUB_OWNER, GITHUB_REPO_NAME));
        });

        step((format("Go to repository %s issues page", GITHUB_REPO_NAME)), () -> {
            $("span[data-content='Issues']").click();
        });

        step("Get repository issues list (API method)");
        List<Issue> issueList = apiOps.getIssueList();

        for (Issue issue : issueList) {
            step("Compare Issue's expected value (taken by API) vs actual) ", () -> {
                $(format("#issue_%s_link", issue.getNumber())).shouldHave(text(issue.getTitle()));
            });
        }
    }
}
