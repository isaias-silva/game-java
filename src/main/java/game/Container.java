package game;

import game.model.Phase;

import javax.swing.*;

public class Container extends JFrame {

    public Container() {
        add(new Phase("res//background.jpg"));
        setTitle("aren battle");
        setSize(600, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Container();
    }
}
