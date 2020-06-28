package dictionaryapi;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
//import org.json.*;

import utils.CheckUtil;
import connection.MyConnection;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 10:54 AM
 */


public class DictionaryApi {


    @Contract(pure = true)
    private static @Nullable String getApiUrlString(String word) {
        if (!CheckUtil.isSet(word))
            return null;
        return Constants.PROTOCOL + "://" + Constants.HOST + Constants.PATH + word;
    }

    public static String getDefinitionData(String word) {
        //could return JSONObject Also
        String url,
                definitionDataString;
//        JSONObject definitionData;

        if (!CheckUtil.isSet(word))
            return null;

        url = getApiUrlString(word);
        definitionDataString = MyConnection.getGETResponse(url);
//        definitionData = new JSONObject(definitionDataString);

        return definitionDataString;
    }
}
