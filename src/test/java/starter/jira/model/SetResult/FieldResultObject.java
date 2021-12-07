package starter.jira.model.SetResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static starter.jira.model.SetComment.ContentComentParent.getData1;
import static starter.jira.model.SetComment.ContentComentParent.getData2;

@Data
@JsonPropertyOrder(value = {"customfield_10304"})
public class FieldResultObject {

    @JsonProperty("customfield_10304")
    private Map<String, Object> customfield_10304;




}
