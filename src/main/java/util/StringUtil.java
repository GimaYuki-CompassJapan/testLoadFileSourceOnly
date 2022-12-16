package util;

public class StringUtil {

    public static boolean isNull(String userId){
        boolean result = true;
        if(userId != null && !userId.isEmpty()){
            result = false;
        }
        return result;
    }
}
