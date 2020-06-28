package test;

import dictionaryapi.DictionaryApi;
/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 9:01 PM
 */
public class DictionaryApiTest {
    public static void main(String[] args) {
        String word = "hello",
                definitionData = DictionaryApi.getDefinitionData(word);
        System.out.println(definitionData);
    }
}
