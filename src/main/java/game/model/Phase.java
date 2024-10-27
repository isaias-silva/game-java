package game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Phase extends JPanel implements ActionListener {
    private Image background;
    private Player player;
    private Timer timer;

    public Phase(final String backgroundPath) {
        ImageIcon imageIcon = new ImageIcon(backgroundPath);
        setDoubleBuffered(true);
        setFocusable(true);

        background = imageIcon.getImage();
        player = new Player();
        player.load();
        addKeyListener(new KeyboardAdapter());
        timer= new Timer(7,this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(this.background, 0, 0, null);
        graphics2D.drawImage(this.player.getSprite(), player.getX(), player.getY(), this);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }

    private class KeyboardAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            super.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
            super.keyReleased(e);
        }
    }
}

