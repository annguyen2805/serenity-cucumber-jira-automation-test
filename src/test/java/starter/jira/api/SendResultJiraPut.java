package starter.jira.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.jira.model.Authentication;
import starter.jira.model.SetComment.Comment;
import starter.jira.model.SetResult.FieldResultObject;
import starter.jira.model.SetResult.FieldsObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static starter.jira.model.SetComment.ContentComentParent.getData1;

public class SendResultJiraPut {
    public static void main(String[] args) {

        FieldsObject fieldsObject = new FieldsObject(getField("test api 3.12132131"));
        System.out.println(fieldsObject);
        Response res = callAPI(fieldsObject, "BOOK-1512");
        System.out.println(res.asString());
        System.out.println(res.getStatusCode());
    }

    public static Response sendResultJira(FieldsObject result, String idIssue ){
        new Authentication();
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .pathParam("issueIdOrKey", idIssue)
                .when()
                .body(result)
                .put("/issue/{issueIdOrKey}");

    }

    public static Response callAPI(FieldsObject result, String idIssue){
        return sendResultJira(result, idIssue);
    }

    public static Map<String, Object> getField(String comment){
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> contentValue = Collections.singletonList(getData1(comment));
        data.put("type", "doc");
        data.put("version", 1);
        data.put("content", contentValue );
        data1.put("customfield_10304", data);
        return data1;
    }
}
