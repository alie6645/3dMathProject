package display.blob;

import projection.ProjectionCamera;
import projection.Vector3;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class Polygon3D {
    private List<Vector3> points;

    public void addPoint(Vector3 point){
        points.add(point);
    }
    public void draw(Graphics2D g2, ProjectionCamera projection) {
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        int index = 0;
        for (Vector3 point:points){
            Point2D normal = projection.convert(point);
            if (normal != null){
                x[index] = normal.getX();
                y[index] = normal.getY();
            }
        }
    }
}
