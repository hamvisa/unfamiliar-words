package test;

import dbadapter.DBAdapter;
import dictionaryapi.DictionaryApi;
import type.Type;

import static utils.CheckUtil.isSet;

/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/28/20
 * Time: 9:25 PM
 */
public class DBAdapterTest {
    public static void main(String[] args) {
        String word = "hello",
                definitionData = DictionaryApi.getDefinitionData(word);

        if (!isSet(definitionData)) {
            System.out.println("Definition data not set");
            return;
        }

        DBAdapter.insertWordDefinition(word, definitionData);

        if (DBAdapter.wordExistsInDb(word)) {
            String definition = DBAdapter.getWordDefinition(word);
            System.out.println(word);
            System.out.println(definition);
        }

        DBAdapter.incrementWordHitCount(word);
    }
}
