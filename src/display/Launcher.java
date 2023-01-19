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
        Box3D box1 = getBox(10,10,4,10,10,10);
        box1.setColor(Color.GREEN);
        panel.add(box1);
        Box3D box2 = getBox(20,10,4,20,20,20);
        box2.setColor(Color.GREEN);
        panel.add(box2);
        panel.add(new Grid3D(5,5));
        frame.add(panel);

        frame.setVisible(true);
    }

    public static Box3D getBox(double x, double y, double z, double height, double width, double depth){
        return new Box3D(new Vector3(x,y,z),height,width,depth);
    }
}
