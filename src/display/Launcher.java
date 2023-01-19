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
        KeyController controller = new KeyController(panel);
        frame.addKeyListener(controller);
        panel.add(new Box3D(new Vector3(10,10,4),10,10,10));
        panel.add(new Box3D(new Vector3(20,10,4),20,20,20));
        //panel.projection.rotateScreen(0,-0.3,0);
        frame.add(panel);

        frame.setVisible(true);
    }
}
