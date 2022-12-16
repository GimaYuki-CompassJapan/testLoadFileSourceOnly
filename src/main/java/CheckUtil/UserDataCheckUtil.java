package CheckUtil;

import Constatnt.JsonConstant;
import Constatnt.RegularExpressions;

import java.io.PushbackReader;
import java.util.List;
import java.util.Map;

public class UserDataCheckUtil {

    public static void check(List<Map<String, Object>> userDataList){
        for(Map<String, Object> userDataMap : userDataList){
            for(Map.Entry<String, Object> userDataEntry : userDataMap.entrySet()){
                switch (userDataEntry.getKey()) {
                    case JsonConstant.JSON_ID:
                        userId(userDataEntry.getValue().toString());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void userId(String userId){
        System.out.println("IDの文字列:" + userId.length());
        if(userId.length() > 5){
            System.out.println("userIdは5桁までです。（" + userId + "）");
        }
        if(!userId.matches(RegularExpressions.REGULAR_EXPRESSIONS_ONLY_NUMBER)){
            System.out.println("userIdは数字のみ使用できます。（" + userId + "）");
        }
    }
}
