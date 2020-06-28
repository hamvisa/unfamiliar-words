package dbadapter;


import org.jetbrains.annotations.Nullable;
import java.sql.*;

import static utils.CheckUtil.isSet;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 10:06 PM
 */


public class DBAdapter extends BaseDbAdapter {


    public static boolean wordExistsInDb(String word) {
        return isSet(getWordDefinition(word));
    }

    public static @Nullable String getWordDefinition(String word) {
        String query = "SELECT " + Constants.WORD_COL_NAME + ", " + Constants.DEFINITION_COL_NAME + " " +
                "FROM " + Constants.TABLE_NAME + " " +
                "WHERE " + Constants.WORD_COL_NAME + " = '" +
                word +
                "';";
        ResultSet rs = select(query);

        if (!isSet(rs))
            return null;

        try {
            if (rs.next())
                return rs.getString(Constants.DEFINITION_COL_NAME);
        } catch (SQLException e) {
            System.out.print("getWordDefinition Exception. Word: " + word + "\t");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void incrementWordHitCount(String word) {
        if (isSet(word) && wordExistsInDb(word)) {
            String query = "UPDATE " + Constants.TABLE_NAME + " " +
                    "SET " + Constants.COUNT_COL_NAME + " = " + Constants.COUNT_COL_NAME + " + 1 " +
                    "WHERE " + Constants.WORD_COL_NAME + " = '" +
                    word +
                    "';";
            update(query);
        }
    }

    public static void insertWordDefinition(String word, String definition) {
        if (!isSet(word) || !isSet(definition))
            return;

        String query = "INSERT INTO " + Constants.TABLE_NAME + "(" + Constants.WORD_COL_NAME + ", " + Constants.DEFINITION_COL_NAME + ") " +
                "VALUES ('" +
                word +
                "', '" +
                definition +
                "');";

        insert(query);
    }
}
