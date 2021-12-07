package starter.jira.model.SetComment;

import lombok.Data;

import java.util.Map;

@Data
public class Comment {
    public Map<String,Object> body;

    public Comment(Map<String, Object> body) {
        this.body = body;
    }

}
