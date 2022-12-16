package util;

import Constatnt.JsonConstant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.Node;
import model.userModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.T;

public class JsonUtil {
    // path jsonファイルのディレクトリパス
    // type jsonをパースした際の最終的な型
    // return typeで指定されてた型
    public static <T> T parse(final Path path, final TypeReference type ) throws IOException {
        // ファイルデータの内容を読み込み
        Stream<String> lines = Files.lines(path);
        // Arrayの文字列を1つにまとめる処理
        String json = lines.collect(Collectors.joining(System.lineSeparator()));

        // ObjectMpperを用意
        ObjectMapper mapper = new ObjectMapper();
        try {
            // まとめた文字列をtypeの型に落とし込む
            T obj = (T)mapper.readValue(json, type);

            return obj;
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }

    public static Map<String, Object> parseMap(final Path path) throws IOException {
        Stream<String> lines = Files.lines(path);
        String json = lines.collect(Collectors.joining(System.lineSeparator()));
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);

            Map<String, Object> objMap = new HashMap<>();
            for(JsonNode node : jsonNode.get(JsonConstant.JSON_USER_DATA_LIST)){
                objMap = mapper.readValue(node.toString(), new TypeReference<Map<String, Object>>() {});
            }
            return objMap;
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }
}
