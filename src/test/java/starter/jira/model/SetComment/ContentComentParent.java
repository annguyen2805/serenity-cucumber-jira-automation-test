package starter.jira.model.SetComment;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ContentComentParent {
    private String type;
    List<Map<String, Object>> content;



    public static Map<String, Object> getData1(String comment){

            Map<String, Object> data = new HashMap<>();
            List<Map<String, Object>> dataContent = Collections.singletonList(getData2(comment));
            data.put("type", "paragraph");
            data.put("content",  dataContent);
            return data;

    }

    public static Map<String, Object> getData2(String comment){

        Map<String, Object> data = new HashMap<>();
        data.put("text", comment);
        data.put("type",  "text");
        return data;

    }

}
