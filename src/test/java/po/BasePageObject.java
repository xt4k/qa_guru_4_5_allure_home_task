package po;

import io.qameta.allure.Step;
import pojo.Issue;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class BasePageObject {

    @Step("Open github repository {githubRepoName}")
    public BasePageObject openBaseUrl(String baseUrl, String githubOwner, String githubRepoName) {
        open(format("%s/%s/%s", baseUrl, githubOwner, githubRepoName));
        return this;
    }

    @Step("Go to repository  issues page")
    public BasePageObject openIssuesPage() {
        $("span[data-content='Issues']").click();
        return this;
    }

    @Step("Compare Issue's expected value (taken by API) vs actual (on page)")
    public BasePageObject compareIssueName(Issue issue) {
        $(format("#issue_%s_link", issue.getNumber())).shouldHave(text(issue.getTitle()));
        return this;
    }
}
