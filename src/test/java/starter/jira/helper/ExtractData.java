package starter.jira.helper;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

public class ExtractData {

    public static int getTotalIssue(Response response){
        return JsonPath.parse(response.asString()).read("$.total");
    }

    public static List<String> getIssueID(Response response){
        return JsonPath.parse(response.asString()).read("$.issues..key");
    }

    public static List<String> getFeature(Response response){
        return JsonPath.parse(response.asString()).read("$..description.content..text");
    }
    public static List<String> getModule(Response response){
        return JsonPath.parse(response.asString()).read("$..customfield_10284.value");
    }

}
