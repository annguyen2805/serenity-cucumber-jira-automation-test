package starter;

import java.util.ArrayList;
import java.util.List;

public class testmail {


    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("@BOOK-1436");
        String b = a.get(0).substring(1,a.get(0).length());
        System.out.println(b);
    }
}
