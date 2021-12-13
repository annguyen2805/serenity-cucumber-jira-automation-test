package starter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static starter.jira.helper.ConfigResourceBundle.CONFIG_RESOURCE;

public class testmail {


    public static void main(String[] args) {
        System.out.println(System.getProperty("language"));
        System.out.println(System.getenv("language"));
        System.out.println(CONFIG_RESOURCE.getValue("hello"));
    }
    @Test
    public void tesst() {
        System.out.println(System.getProperty("language"));
        System.out.println(CONFIG_RESOURCE.getValue("hello"));

    }
}
