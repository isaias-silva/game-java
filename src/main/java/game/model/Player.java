package game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private Image sprite;
    private int x, y;
    private int dx, dy;

    private int width, height;

    public Player() {
        x = 100;
        y = 100;

    }

    public void load() {
        ImageIcon reference = new ImageIcon("res//player.png");
        sprite = reference.getImage();
        width = sprite.getWidth(null);
        height = sprite.getHeight(null);
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                dy = -3;
                break;

            case KeyEvent.VK_DOWN:
                dy = 3;
                break;
            case KeyEvent.VK_LEFT:
                dx = -3;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 3;
                break;
        }
    }

    public void keyRelease(KeyEvent key) {
        int code = key.getKeyCode();
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
            dy = 0;
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT) {
            dx = 0;
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getSprite() {
        return sprite;
    }
}
