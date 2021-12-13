package starter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import starter.jira.api.SendCommentPost;
import starter.jira.api.SendResultJiraPut;
import starter.jira.model.SetComment.Comment;
import starter.jira.model.SetResult.FieldsObject;

import java.util.List;

public class Hook {
    private SendCommentPost sendCommentPost = new SendCommentPost();
    private SendResultJiraPut sendResultJiraPut = new SendResultJiraPut();

    @After
    public void tear_down(Scenario scenario) {
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        System.out.println(scenario.getId());
        System.out.println(scenario.getUri());

        if (tags.size() > 0) {
            System.out.println(scenario.getName() + "---------------");
            String idIssue = tags.get(0).substring(1, tags.get(0).length());
            String result = String.valueOf(scenario.getStatus());
            String comment = scenario.getName() + result;
            sendCommentToJira(idIssue, comment);
            sendResultJira(idIssue, result);
        }

    }

    public void sendCommentToJira(String issueID, String commentJira) {
        Comment comment = new Comment(sendCommentPost.getData(commentJira));
        sendCommentPost.callAPI(comment, issueID);
    }

    public void sendResultJira(String idIssue, String Result) {
        FieldsObject fieldsObject = new FieldsObject(sendResultJiraPut.getField(Result));
        sendResultJiraPut.callAPI(fieldsObject, idIssue);
    }
}
