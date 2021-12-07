package starter.jira.model.searchIssue;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class SearchObject {
    private String jql;
    private int maxResults;
    private int startAt;
    private List<String> fields;

    public SearchObject(int startAt){
        this.startAt = startAt;
        this.jql ="project = BOOK AND \"Test Type[Dropdown]\" = Automation order by created DESC";
        //this.jql = "project = BOOK order by created DESC";
        this.maxResults = 100;
        this.fields = Collections.singletonList("issues");
    }
}
