/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/20/20
 * Time: 7:10 PM
 */

package test;

import sysdata.ClipboardAccess;

public class SystemDataAccessTest {
    public static void main(String[] args) {
        System.out.println(ClipboardAccess.getSelectionOrClipboardContent());
    }
}
