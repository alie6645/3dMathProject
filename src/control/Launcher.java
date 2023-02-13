package control;

import display.blob.Cube;
import display.blob.Mesh;
import display.shape.Box3D;
import display.shape.Grid3D;
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
        MouseController mouse = new MouseController(panel);
        frame.addMouseMotionListener(mouse);
        Mesh floor = new Mesh(new Vector3(-50,20,-50),new Vector3(2,0,0), new Vector3(0,0,2),100,100);

        Cube cube = new Cube(new Vector3(0,10,4),10);
        Cube cube1 = new Cube(new Vector3(-10,10,-10),10);
        Cube cube2 = new Cube(new Vector3(0,10,-14),10);

        panel.add(cube);
        panel.add(cube1);
        panel.add(cube2);
        panel.add(floor);

        panel.addPointLight(new Vector3(0,0,0),50);
        panel.addPointLight(new Vector3(50,10,50), 50);
        panel.addAmbient(0.2);

        frame.add(panel);

        frame.setVisible(true);
    }

    public static Box3D getBox(double x, double y, double z, double height, double width, double depth){
        return new Box3D(new Vector3(x,y,z),height,width,depth);
    }
}
