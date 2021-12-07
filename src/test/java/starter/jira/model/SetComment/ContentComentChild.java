package starter.jira.model.SetComment;

import lombok.Data;

@Data
public class ContentComentChild {
    private String text;
    private String type;

    public ContentComentChild(String text){
        this.text =text;
        this.type = "text";
    }
}
