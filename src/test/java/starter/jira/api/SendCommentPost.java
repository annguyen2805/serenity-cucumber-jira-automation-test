package starter.jira.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.jira.model.Authentication;
import starter.jira.model.SetComment.Comment;

import java.util.*;

import static io.restassured.RestAssured.given;
import static starter.jira.model.SetComment.ContentComentParent.getData1;

public class SendCommentPost {

    public static void main(String[] args) {
        SendCommentPost sendComment = new SendCommentPost();
        Comment comment = new Comment(sendComment.getData("test send comment api 3/12"));
        System.out.println(comment);
        Response res = sendComment.callAPI(comment,"BOOK-1436");
        System.out.println(res.asString());
    }

    public Response sendJiraPost(Comment comment, String idIssue ){
        new Authentication();
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .pathParam("issueIdOrKey", idIssue)
                .when()
                .body(comment)
                .post("/issue/{issueIdOrKey}/comment");

    }

    public Response callAPI(Comment comment, String idIssue){
        return sendJiraPost(comment, idIssue);
    }

    public Map<String, Object> getData(String comment){
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> contentValue = Collections.singletonList(getData1(comment));
        data.put("type", "doc");
        data.put("version", 1);
        data.put("content", contentValue );
        return data;
    }
}
