package display;

import java.awt.*;

public class ColorModifier {
    public static Color multiply(Color color, double num){
        int r = Math.min((int) (color.getRed()*num), 225);
        int g = Math.min((int) (color.getGreen()*num), 225);
        int b = Math.min((int) (color.getBlue()*num), 225);
        return new Color(r,g,b);
    }
}
