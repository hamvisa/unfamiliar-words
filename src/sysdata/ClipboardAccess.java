/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/20/20
 * Time: 7:00 PM
 */

package sysdata;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import utils.CheckUtil;

public class ClipboardAccess {


    private static final Clipboard selection = Toolkit.getDefaultToolkit().getSystemSelection();
    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();


    public static String getSelectionOrClipboardContent() {
        try {
            String selectionContent = (String) selection.getData(DataFlavor.stringFlavor);
            if (CheckUtil.isSet(selectionContent)) {
                return selectionContent;
            }
        } catch (Exception ignored) {}

        try {
            String clipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);
            if (CheckUtil.isSet(clipboardContent)) {
                return clipboardContent;
            }
        } catch (Exception ignored) {}

        return "";
    }
}
