package sysdata;


import java.awt.*;
import static java.awt.MouseInfo.getPointerInfo;


import static utils.CheckUtil.isSet;

import org.jetbrains.annotations.Nullable;
import type.Type;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/29/20
 * Time: 12:27 AM
 */


public class CursorPosition {
    private static PointerInfo pointerInfo;

    private static void setPointerInfo() {
        try {
            pointerInfo = getPointerInfo();
        } catch (HeadlessException e) {
            pointerInfo = null;
            System.out.print("Get Pointer Info Exception. Message: ");
            System.out.println(e.getMessage());
        }
    }

    public static Type.@Nullable PointCoordinates getCursorCoordinates() {
        setPointerInfo();

        if (isSet(pointerInfo)) {
            Point point = pointerInfo.getLocation();
            return new Type.PointCoordinates(point.x, point.y);
        }

        return null;
    }
}
