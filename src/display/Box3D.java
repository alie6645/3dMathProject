package display;

import projection.Vector3;
import projection.VectorMath;

import java.util.ArrayList;
import java.util.List;

public class Box3D implements Shape3D{
    ArrayList<Line3D> lines = new ArrayList<Line3D>();

    public Box3D(Vector3 point, double height, double width, double depth){
        Vector3 up = new Vector3(0,height,0);
        Vector3 in = new Vector3(0,0,depth);
        Vector3 side = new Vector3(width,0,0);
        lines.add(new Line3D(point, VectorMath.add(point,up)));
        lines.add(new Line3D(point, VectorMath.add(point,in)));
        lines.add(new Line3D(point, VectorMath.add(point,side)));
    }

    @Override
    public List<Line3D> getLines() {
        return lines;
    }
}
