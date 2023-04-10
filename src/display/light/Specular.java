package display.light;

import display.blob.Polygon3D;
import projection.Plane;
import projection.Vector3;
import projection.VectorMath;

public class Specular{
    public static Polygon3D getSpecular(PointSource light, Vector3 cam, Polygon3D poly){
        Vector3 normal = poly.getNormal();
        Vector3 center = poly.getCenter();
        if (VectorMath.dot(VectorMath.subtract(cam,center),VectorMath.subtract(normal,center))<0){
            //return null;
        }
        Plane plane = new Plane(normal,center);
        Vector3 b = VectorMath.genericIntersect(light.location,normal,plane);
        Vector3 c = VectorMath.genericIntersect(cam,normal,plane);
        Vector3 bc = VectorMath.subtract(b,c);
        double camDist = VectorMath.subtract(cam,c).magnitude();
        double lightDist = VectorMath.subtract(light.location,b).magnitude();

        double total = camDist + lightDist;
        double ratio = lightDist/total;
        Vector3 spec = VectorMath.add(c,VectorMath.multiply(bc,ratio));
        Polygon3D highlight = new Polygon3D();
        highlight.addPoint(spec);
        highlight.addPoint(VectorMath.add(spec,VectorMath.multiply(bc.norm(),4)));
        Vector3 side = VectorMath.cross(bc,normal).norm();
        highlight.addPoint(VectorMath.add(spec,VectorMath.multiply(side,2)));
        return highlight;
    }
}
