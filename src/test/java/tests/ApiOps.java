package tests;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import pojo.Issue;

import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static tests.BaseTest.*;

public class ApiOps {
    public List<Issue> getIssueList() {
        Response response =
                given()
                        .filter(new AllureRestAssured())
                        .baseUri(BaseURI)
                        .header("Accept", "application/vnd.github.v3+json")
                        .when()
                        .get(format("repos/%s/%s/issues", GITHUB_OWNER, GITHUB_REPO_NAME));
        return response.then().extract().jsonPath().getList("$", Issue.class);
    }

    @Step("Get repository issues list (API method)")
    public List<Issue> getIssueListStep() {
        Response response =
                given()
                        .filter(new AllureRestAssured())
                        .baseUri(BaseURI)
                        .header("Accept", "application/vnd.github.v3+json")
                        .when()
                        .get(format("repos/%s/%s/issues", GITHUB_OWNER, GITHUB_REPO_NAME));
        return response.then().extract().jsonPath().getList("$", Issue.class);
    }
}