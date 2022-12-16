package Constatnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonConstant {
    public static final String JSON_USER_DATA_LIST = "userDataList";
    public static final String JSON_ID = "ID";
    public static final String JSON_NAME = "Name";
    public static final String JSON_GENDER = "Gender";
    public static final String JSON_AGE = "Age";

    public static final List<String> JSON_USER_DATA_ITEM_LIST = Collections.unmodifiableList(new ArrayList<String>() {{
        add(JSON_ID);
        add(JSON_NAME);
        add(JSON_GENDER);
        add(JSON_AGE);
    }});
}
