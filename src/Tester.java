import projection.ProjectionCamera;
import projection.Vector3;

import java.awt.geom.Point2D;

public class Tester {
    public static void main(String[] args) {
        ProjectionCamera projection = new ProjectionCamera();
        Vector3 line = new Vector3(10,10,10);
        projection.rotateScreen(0,0,0);
        Point2D point = projection.convert(line);
        System.out.println("X: " + point.getX());
        System.out.println("Y: " + point.getY());
    }
}
