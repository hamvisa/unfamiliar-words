import sysdata.ClipboardAccess;
import dbadapter.DBAdapter;
import dictionaryapi.DictionaryApi;
import static utils.CheckUtil.isSet;
import display.TextFrame;
/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/28/20
 * Time: 10:42 PM
 */


public class Main {
    public static void main(String[] args) {
        String word = ClipboardAccess.getSelectionOrClipboardContent(),
                definition = "";

        if (!isSet(word)) {
            System.out.println("Word Not Present in Selection / Clipboard");
            return;
        }

        if (DBAdapter.wordExistsInDb(word)) {
            definition = DBAdapter.getWordDefinition(word);
            if (isSet(definition))
                DBAdapter.incrementWordHitCount(word);
        }  else {
            definition = DictionaryApi.getDefinitionData(word);
            if (isSet(definition))
                DBAdapter.insertWordDefinition(word, definition);
        }

        if (!isSet(definition))
            return;

        TextFrame.display(word, definition);
    }
}
