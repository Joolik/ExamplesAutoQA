import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.TestData;
import entities.issues.Issue;
import requests.IssueRequests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requests.BaseRequests.getResponseObject;

public class IssueAPITest {

    private IssueRequests reqIssue;

    @BeforeClass
    public void setUpIssue() {
        reqIssue = new IssueRequests();
    }

    /*
     * Создание issue с attachment
     */
    @Test(dataProvider = "issueDataProvider", dataProviderClass = TestData.class)
    public void addIssueTest(final Issue issue) {
        Response response = reqIssue.addIssue(issue);
        response.then()
                .log().status()
                .statusCode(201);
        Issue responseIssue = getResponseObject(response.getBody().asString(), Issue.class);
        assertThat(issue.getSummary(), equalTo(responseIssue.getSummary()));
    }

    /*
     * Обновление issue
     */
    @Test(dataProvider = "issueUpdateDataProvider", dataProviderClass = TestData.class)
    public void updateIssueTest(final Issue issue, final Issue issueUpdated) {

        // Создание issue
        Response response = reqIssue.addIssue(issue);
        response.then()
                .log().status()
                .statusCode(201);
        Issue responseIssue = getResponseObject(response.getBody().asString(), Issue.class);

        // Обновление созданного issue
        reqIssue.updateIssue(issueUpdated, responseIssue.getId())
                .then()
                .log().status()
                .statusCode(200);
    }

    /*
     * Обновление несуществующего issue
     */
    @Test(dataProvider = "issueUpdateDataProvider", dataProviderClass = TestData.class)
    public void updateIssueNonExistTest(final Issue issue, final Issue issueUpdated) {
        reqIssue.updateIssue(issueUpdated, reqIssue.getMaxIssueId() + 100)
                .then()
                .log().status()
                .statusCode(404);
    }

}
