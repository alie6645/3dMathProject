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
        if (x>600||y>600||x<200||y<200){
            bot.mouseMove(400,400);
            x = 400;
            y = 400;
            lastX = 400;
            lastY = 400;
        }
        double ypart = cam.normal.z;
        double zpart = cam.normal.x;
        cam.rotateScreen(-rotate * (y-lastY) * ypart,rotate*(x-lastX),zpart*rotate*(y-lastY));
        panel.repaint();
        lastX = x;
        lastY = y;
    }
}
