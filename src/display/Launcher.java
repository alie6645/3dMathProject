package display;

import projection.Vector3;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400,400));
        Panel panel = new Panel();
        panel.add(new Box3D(new Vector3(100,100,10),100,100,100));
        frame.add(panel);

        frame.setVisible(true);
    }
}
