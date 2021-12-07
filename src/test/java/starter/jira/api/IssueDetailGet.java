package starter.jira.api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import starter.jira.model.Authentication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class IssueDetailGet {
    public static void main(String[] args) throws IOException {
        CreateFeature();
    }


    public Response getIssueDetail(String idIssue){
        new Authentication();
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .pathParam("issueIdOrKey", idIssue)
                .when()
                .get("/issue/{issueIdOrKey}");

    }

    public Response callAPI( String idIssue){
        return getIssueDetail(idIssue);
    }

    public static void CreateFeature() throws IOException {
        RestAssured.baseURI = "https://citigo.atlassian.net/";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("an.nv@citigo.com.vn");
        authScheme.setPassword("7ISWJPjEueClBPRv93bn207D");
        RestAssured.authentication = authScheme;
        RequestSpecification httpRequest = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON);
        Response response = httpRequest.request(Method.GET, "rest/api/3/issue/BOOK-1436");
        List<String> de = JsonPath.parse(response.asString()).read("$..description.content..text");
        System.out.println(de);
        FileWriter writer = new FileWriter("src/test/resources/features/search/output.feature");
        for(String str: de) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

}
