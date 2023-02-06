package control;

import projection.ProjectionCamera;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    Panel panel;
    ProjectionCamera cam;
    int lastX;
    int lastY;
    final double rotate = 0.001;
    public MouseController(Panel panel) {
        this.panel = panel;
        this.cam = panel.projection;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Robot bot;
        try {
            bot = new Robot();
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
        int x = e.getX();
        int y = e.getY();
        if (x>300||y>300||x<100||y<100){
            bot.mouseMove(200,200);
            x = 200;
            y = 200;
            lastX = 200;
            lastY = 200;
        }
        cam.rotateScreen(-rotate * (y-lastY),rotate*(x-lastX),0);
        panel.repaint();
        lastX = x;
        lastY = y;
    }
}
