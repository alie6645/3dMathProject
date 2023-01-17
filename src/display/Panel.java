package display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JComponent {

    ArrayList<Shape3D> shapes = new ArrayList<Shape3D>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Shape3D shape:shapes){
            List<Line3D> lines = shape.getLines();
            for (Line3D line:lines){

            }
        }
    }
}
