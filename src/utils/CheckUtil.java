package utils;

import java.util.Arrays;
/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 9:32 AM
 */
public class CheckUtil {

    public static < T > boolean isSet(T t) {
        if (t != null) {

            Class tClass = t.getClass();

            if (tClass == String.class) {
                return t != "";
            }

            return true;
        }
        return false;
    }
}
