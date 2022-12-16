import CheckUtil.UserDataCheckUtil;
import Constatnt.JsonConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import util.JsonUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, IOException {

        // jsonファイルのパスを取得
        Path path = Paths.get("personaldata.json");

        // jsonファイルをMap<String, List<Map<String, Object>>>型に落とし込む
        Map<String, List<Map<String, Object>>> userDataMap = JsonUtil.parse(path, new TypeReference<HashMap<String, ArrayList<HashMap<String, Object>>>>() {
        });

        //ユーザデータのフォーマットチェック
        UserDataCheckUtil.check(userDataMap.get(JsonConstant.JSON_USER_DATA_LIST));
    }
}
