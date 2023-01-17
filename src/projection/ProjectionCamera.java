package projection;

import java.awt.geom.Point2D;

public class ProjectionCamera {
    Vector3 camera = new Vector3(0,0,0);
    Vector3 rotation = new Vector3(0, 0, 0);
    Plane screen = new Plane(0,0,1,2);
    Vector3 normal = new Vector3(0,0,2);

    public Vector3 intersect(Vector3 line, Plane plane){
        double a = plane.a;
        double b = plane.b;
        double c = plane.c;
        double x = line.x;
        double y = line.y;
        double z = line.z;
        double d = plane.d;
        double t = d - a * camera.x - b * camera.y - c * camera.z;
        t = t / (a * x - a * camera.x + b * y - b * camera.y + c * z - c * camera.z);
        return new Vector3(t * (x - camera.x), t * (y - camera.y), t * (z - camera.z));
    }

    public void rotateZ(Vector3 point, double angle){
        if (angle != 0) {
            double x = point.x;
            double y = point.y;
            point.x = x*Math.cos(angle)-y*Math.sin(angle);
            point.y = x*Math.sin(angle)+y*Math.cos(angle);
        }
    }

    public void rotateX(Vector3 point, double angle){
        if (angle != 0) {
            double z = point.z;
            double y = point.y;
            point.z = z*Math.cos(angle)-y*Math.sin(angle);
            point.y = z*Math.sin(angle)+y*Math.cos(angle);
        }
    }

    public void rotateY(Vector3 point, double angle){
        if (angle != 0) {
            double x = point.x;
            double z = point.z;
            point.x = x*Math.cos(angle)-z*Math.sin(angle);
            point.z = x*Math.sin(angle)+z*Math.cos(angle);
        }
    }

    public void rotate(Vector3 point, double x, double y, double z){
        rotateX(point, x);
        rotateY(point, y);
        rotateZ(point, z);
    }

    public void rotate(Vector3 point){
        rotate(point, rotation.x, rotation.y, rotation.z);
    }

    public void rotateReverse(Vector3 point){
        rotateX(point, -rotation.x);
        rotateY(point, -rotation.y);
        rotateZ(point, -rotation.z);
    }

    public void rotateScreen(int x, int y, int z){
        Vector3 norm = new Vector3(normal);
        rotate(norm, x, y, z);
        screen.update(norm, norm);

    }

    public Point2D convert(Vector3 point){
        Vector3 intersection = intersect(VectorMath.subtract(point,camera),screen);
        rotateReverse(intersection);
        return new Point2D.Double(intersection.x, intersection.y);
    }
}
