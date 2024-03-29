package projection;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 vec){
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3 norm(){
        return new Vector3(x/magnitude(),y/magnitude(),z/magnitude());
    }

    public String toString(){
        return "x: " + x + ", y: " + y + ", z: " + z;
    }

}
