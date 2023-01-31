package control;

import projection.ProjectionCamera;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    Panel panel;
    ProjectionCamera cam;
    boolean rotate = false;
    public KeyController(Panel panel){
        this.panel = panel;
        this.cam = panel.projection;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p'){
            rotate = !rotate;
        }
        if (rotate) {
            if (e.getKeyChar() == 'w') {
                cam.rotateScreen(0.01, 0, 0);
            }
            if (e.getKeyChar() == 'a') {
                cam.rotateScreen(0, -0.01, 0);
            }
            if (e.getKeyChar() == 's') {
                cam.rotateScreen(-0.01, 0, 0);
            }
            if (e.getKeyChar() == 'd') {
                cam.rotateScreen(0, 0.01, 0);
            }
            if (e.getKeyChar() == 't') {
                cam.rotateScreen(0, 0, 0.01);
            }
        } else {
            if (e.getKeyChar() == 'w') {
                cam.move(0, 0, 0.2);
            }
            if (e.getKeyChar() == 'a') {
                cam.move(-0.2, 0, 0);
            }
            if (e.getKeyChar() == 's') {
                cam.move(0, 0, -0.2);
            }
            if (e.getKeyChar() == 'd') {
                cam.move(0.2, 0, 0);
            }
            if (e.getKeyChar() == 'q') {
                cam.move(0, 0.2, 0);
            }
            if (e.getKeyChar() == 'e'){
                cam.move(0,-0.2,0);
            }
        }
        panel.repaint();
    }
}
