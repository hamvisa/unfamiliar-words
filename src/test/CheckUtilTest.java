package test;

import utils.CheckUtil;
/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 9:57 AM
 */
public class CheckUtilTest {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "Sahil Maniar";
        int int1 = 1;
        int[] intarr = {1,2,3};

        System.out.println(CheckUtil.isSet(str1));
        System.out.println(CheckUtil.isSet(str2));
        System.out.println(CheckUtil.isSet(int1));
        System.out.println(CheckUtil.isSet(intarr));
    }
}
