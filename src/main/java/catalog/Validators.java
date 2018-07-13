package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String s){
        return s==null || s.trim().isEmpty();
    }

    public static boolean isEmpty(List<String> list){
        return list==null || list.size()==0;
    }

}
