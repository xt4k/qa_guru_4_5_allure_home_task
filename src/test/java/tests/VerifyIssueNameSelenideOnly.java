package tests;


import org.junit.jupiter.api.Test;
import pojo.Issue;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class VerifyIssueNameSelenideOnly extends BaseTest {

    @Test
    void shouldFindSelenideInGitHub() {
        open(format("%s/%s/%s", BASE_URL, GITHUB_OWNER, GITHUB_REPO_NAME));
        $("span[data-content='Issues']").click();
        List<Issue> issueList = apiOps.getIssueList();
        for (Issue issue : issueList)
            $(format("#issue_%s_link", issue.getNumber())).shouldHave(text(issue.getTitle()));
    }
}
