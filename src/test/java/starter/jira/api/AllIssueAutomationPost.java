package starter.jira.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.jira.model.Authentication;
import starter.jira.model.searchIssue.SearchObject;

import static io.restassured.RestAssured.given;

public class AllIssueAutomationPost {

    public static void main(String[] args) {
        SearchObject searchObject = new SearchObject(0);
        System.out.println(callAPI(searchObject).asString());
    }

    public static Response searchAllIssueAutomation(SearchObject searchObject){
        new Authentication();
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .when()
                .body(searchObject)
                .post("search");

    }

    public static Response callAPI(SearchObject searchObject ){
        return searchAllIssueAutomation(searchObject);
    }

}
