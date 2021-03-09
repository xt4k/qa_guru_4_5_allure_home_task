package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pojo.Issue;

import java.util.List;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Github repo functional tests")
@Feature("Issues operations")
@Story("Method_Step-style markup")
public class VerifyIssueNameMethodStep extends BaseTest {

    @Test
    @Tags({ @Tag("web"), @Tag("reusable"), @Tag("method-step") })
    @Link(name = "BASE_URL", value = BASE_URL)
    @DisplayName("3. Check Github repository issues name (Method_Step-style markup)")
    @Owner("aqa")
    @Severity(CRITICAL)
    void compareGithubRepoIssueName() {
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
