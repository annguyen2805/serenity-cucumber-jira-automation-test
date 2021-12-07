package starter.jira;

import io.cucumber.java.sr_latn.I;
import io.restassured.response.Response;
import starter.jira.api.AllIssueAutomationGet;
import starter.jira.api.AllIssueAutomationPost;
import starter.jira.api.IssueDetailGet;
import starter.jira.helper.ConvertString;
import starter.jira.helper.ExtractData;
import starter.jira.model.searchIssue.SearchObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFeatureFromJira {
    private static AllIssueAutomationPost allIssueAutomation;
    private static IssueDetailGet issueDetail;
    private static SearchObject searchObject;

    public static void main(String[] args) throws IOException {
        // Khai bao
        allIssueAutomation = new AllIssueAutomationPost();
        issueDetail = new IssueDetailGet();
        searchObject = new SearchObject(0);
        // get list issue API
        Response resTotalIssue = allIssueAutomation.callAPI(searchObject);
        int totalIssue = ExtractData.getTotalIssue(resTotalIssue);
        List<String> IssueAll = new ArrayList<>();
        for(int i = 0; i < totalIssue; i= i+100){
            searchObject = new SearchObject(i);
            Response res = allIssueAutomation.callAPI(searchObject);
            List<String> issueIDs = ExtractData.getIssueID(res);
           IssueAll.addAll(issueIDs);
        }
        System.out.println(IssueAll.size());

        System.out.println(IssueAll);
        for(String issueID : IssueAll){
            System.out.println(issueID);
            //Get feature
            Response res = issueDetail.callAPI(issueID);
            List<String> feature = ExtractData.getFeature(res);
            List<String> module = ExtractData.getModule(res);
            String moduleName = ConvertString.unAccent(module.get(0));

            String path = ConvertString.creatModule(moduleName);
            String createFeature = ConvertString.createFileFeature(path,feature.get(0));
            System.out.println(createFeature);
            FileWriter writer = new FileWriter(createFeature);
            for(int i = 0; i < feature.size(); i++) {
                writer.write(feature.get(i) + System.lineSeparator());
            }
            writer.close();
        }
    }
}
