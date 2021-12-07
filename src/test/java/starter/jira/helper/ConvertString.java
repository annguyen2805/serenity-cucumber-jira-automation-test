package starter.jira.helper;

import java.io.File;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertString {


    public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replaceAll("Đ", "D")
                .replace("đ", "d").toLowerCase()
                .replace(" ","");

    }
    public static String unAccentName(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replaceAll("Đ", "D")
                .replace("đ", "d").toLowerCase();

    }

    public static String  creatModule(String moduleName ){
        String folderParent = moduleName.split("-")[0];
        String folderChild = moduleName.split("-")[1];
        File parent = new File("src/test/resources/features/"+folderParent);
        parent.mkdir();
        File child = new File("src/test/resources/features/"+folderParent+"/"+folderChild);
        child.mkdir();
        return "src/test/resources/features/"+folderParent+"/"+folderChild;
    }

    public static String createFileFeature(String path, String name){
        String nameFile = ConvertString.unAccentName(name.split(":")[1].toLowerCase().trim())
                .replace(" ","_");
        return path + "/" + nameFile +".feature";
    }

    public static void main(String[] args) {
        String test ="Feature: Search by keyword";
        String path = "src/test/resources/features";
        System.out.println(createFileFeature(path,test));
    }
}
