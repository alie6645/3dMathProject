package display;

import projection.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Shape3D{
    ArrayList<Line3D> lines = new ArrayList<Line3D>();

    public Cube(Vector3 point, double height, double width, double depth){

    }

    @Override
    public List<Line3D> getLines() {
        return lines;
    }
}
