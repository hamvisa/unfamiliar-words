package dbadapter;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/28/20
 * Time: 9:46 PM
 */


public class Constants {


    static final String DBNAME = "unfamiliar_words_project_db";
    static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    static final String USER = "unfamiliar-words-project";
    static final String PASSWORD = Confidential.PASSWORD;

    static final String TABLE_NAME = "definitions";
    static final String WORD_COL_NAME = "word";
    static final String DEFINITION_COL_NAME = "definition";
    static final String COUNT_COL_NAME = "count";

}
