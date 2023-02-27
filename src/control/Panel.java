package control;

import display.blob.Blob3D;
import display.shape.Line3D;
import display.blob.Polygon3D;
import display.shape.Shape3D;
import projection.ProjectionCamera;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JComponent {

    ArrayList<Shape3D> shapes = new ArrayList<Shape3D>();
    ArrayList<Blob3D> polygons = new ArrayList<>();
    ProjectionCamera projection = new ProjectionCamera();

    public void add(Shape3D shape){
        shapes.add(shape);
    }
    
    public void sortBlobs(Vector3 cam){
        polygons.sort(new Comparator<Blob3D>() {
            @Override
            public int compare(Blob3D o1, Blob3D o2) {
                Vector3 vec1 = VectorMath.subtract(o1.getCenter(),cam);
                Vector3 vec2 = VectorMath.subtract(o2.getCenter(),cam);
                return (int) (vec2.magnitude() - vec1.magnitude());
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,1000,1000);
        for (Shape3D shape:shapes){
            List<Line3D> lines = shape.getLines();
            g2.setColor(shape.getColor());
            for (Line3D line:lines){
                line.draw(g2, projection);
            }
        }
        sortBlobs(projection.camera);
        for (Blob3D blob:polygons){
            blob.depthSort(projection.camera);
            g2.setColor(blob.getColor());
            List<Polygon3D> surfaces = blob.getPolygons();
            for (Polygon3D poly:surfaces){
                poly.draw(g2, projection);
            }
        }
    }
}
