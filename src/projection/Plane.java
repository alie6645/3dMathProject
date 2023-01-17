package projection;

public class Plane {
    double a;
    double b;
    double c;
    double d;

    public Plane(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void update(Vector3 norm, Vector3 point){
        norm = VectorMath.norm(norm);
        this.a = norm.x;
        this.b = norm.y;
        this.c = norm.z;
        this.d = VectorMath.dot(norm,point);
    }
}
