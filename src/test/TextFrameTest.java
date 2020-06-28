package test;

import dictionaryapi.DictionaryApi;
import display.TextFrame;

/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/28/20
 * Time: 11:03 PM
 */
class TextFrameTest {
    public static void main(String[] args) {
        String word = "Hello",
                definition = DictionaryApi.getDefinitionData(word);
        TextFrame.display(word, definition);
    }
}
