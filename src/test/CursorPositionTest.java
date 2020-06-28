package test;


import sysdata.CursorPosition;

import type.Type;
import static utils.CheckUtil.isSet;

/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/29/20
 * Time: 12:44 AM
 */
public class CursorPositionTest {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i < 5) {

            Type.PointCoordinates pointCoordinates = CursorPosition.getCursorCoordinates();
            if (isSet(pointCoordinates)) {
                System.out.println(pointCoordinates.x + ", " + pointCoordinates.y);
            } else {
                System.out.println("Point Coordinates Null");
            }

            i++;
            Thread.sleep(1000);
        }
    }
}
