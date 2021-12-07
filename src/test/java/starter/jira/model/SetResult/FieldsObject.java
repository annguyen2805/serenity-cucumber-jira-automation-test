package starter.jira.model.SetResult;

import lombok.Data;

import java.util.Map;
@Data
public class FieldsObject {
    private Map<String, Object> fields;

    public FieldsObject(Map<String, Object> fields){
        this.fields = fields;
    }
}
