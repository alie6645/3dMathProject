package display.light;

import display.blob.Polygon3D;
import projection.Vector3;

import java.util.ArrayList;
import java.util.List;

public class LightModel {
    List<Light> lights = new ArrayList<>();

    public void addLight(Light light){
        lights.add(light);
    }

    public void setLight(int index, Light light){
        lights.set(index, light);
    }

    public double getLighting(Vector3 pos, Vector3 norm){
        double total = 0;
        for (Light light:lights){
            total += light.getLight(pos, norm);
        }
        return total;
    }

    public Polygon3D[] getSpecular(Vector3 cam, Polygon3D poly){
        Polygon3D[] highlights = new Polygon3D[getNumPoints()];
        int index = 1;
        for (int i=0; i<lights.size(); i++){
            if (lights.get(i) instanceof PointSource){
                highlights[index] = Specular.getSpecular((PointSource) lights.get(i),cam,poly);
            }
        }
        return highlights;
    }

    public int getNumPoints(){
        int hits = 0;
        for (Light light:lights){
            if (light instanceof PointSource){
                hits++;
            }
        }
        return hits;
    }

}
