package display;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.jetbrains.annotations.NotNull;

import sysdata.CursorPosition;
import type.Type;
import static utils.CheckUtil.isSet;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/28/20
 * Time: 10:49 PM
 */


public class TextFrame {


    private static void positionFrame(@NotNull JFrame frame) {
        Type.PointCoordinates pointCoordinates = CursorPosition.getCursorCoordinates();
        if (isSet(pointCoordinates))
            frame.setBounds(pointCoordinates.x, pointCoordinates.y, 600, 450);
        else
            frame.setSize(600, 450);
    }

    private static void setFrameIcon(@NotNull JFrame frame) {
        try {
            BufferedImage img = ImageIO.read(new File("resources/icon.png"));
            frame.setIconImage(img);
        } catch (IOException e) {
            System.out.println("Image Read Exception. Message: " + e.getMessage());
        }
    }

    private static void setFrameContent(@NotNull JFrame frame, String word, String definition) {
        Component wordComponent = new JTextField(word);
        Component definitionComponent = new JTextArea(definition);

        Color darkTheme = new Color(18, 18, 18);
        wordComponent.setForeground(Color.WHITE);
        wordComponent.setBackground(darkTheme);
        definitionComponent.setForeground(Color.WHITE);
        definitionComponent.setBackground(darkTheme);

        Font wordFont = new Font("Times Roman", Font.BOLD, 20),
                definitionFont = new Font("Times Roman", Font.PLAIN, 20);
        wordComponent.setFont(wordFont);
        wordComponent.setFont(definitionFont);

        frame.add(wordComponent, BorderLayout.PAGE_START);
        frame.add(definitionComponent);
        frame.pack();
    }

    public static void display(String word, String definition) {
        if (!isSet(word) || !isSet(definition))
            return;

        JFrame frame = new JFrame("Unfamiliar Word: " + word);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        positionFrame(frame);
        setFrameIcon(frame);
        setFrameContent(frame, word, definition);

        frame.setVisible(true);
    }
}
