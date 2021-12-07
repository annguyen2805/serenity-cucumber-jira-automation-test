package starter.jira.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.jira.model.Authentication;

import static io.restassured.RestAssured.given;

public class AllIssueAutomationGet {

    public static void main(String[] args) {
        System.out.println(callAPI().asString());
    }

    public static Response getAllIssueAutomation(){
        new Authentication();
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .pathParam("query", "project = BOOK AND \"Test Type[Dropdown]\" = Automation order by created DESC")
                .when()
                .get("search?jql={query}");

    }

    public static Response callAPI( ){
        return getAllIssueAutomation();
    }

}
