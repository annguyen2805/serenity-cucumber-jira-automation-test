package starter.jira.model;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

public class Authentication {

    public Authentication(){
        RestAssured.baseURI = "https://citigo.atlassian.net/rest/api/3";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("an.nv@citigo.com.vn");
        authScheme.setPassword("7ISWJPjEueClBPRv93bn207D");
        RestAssured.authentication = authScheme;
    }

}
