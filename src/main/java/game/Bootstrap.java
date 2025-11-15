package game;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import com.google.common.eventbus.EventBus;

import engine.containers.Container;
import engine.entities.Entity;
import engine.entities.EntityProps;
import engine.event.EventManager;
import engine.phases.Phase;
import game.entities.Player;

public class Bootstrap {

	public static void main(String[] args) {

		ImageIcon background1 = new ImageIcon("res//background.jpg");

		EventManager eventManager = new EventManager(new EventBus());

		ImageIcon spritePlayer = new ImageIcon("res//player.png");

		Entity player = new Player(List.of(spritePlayer.getImage()), new EntityProps(new Point(320, 210), 50, 50));

		Phase phase1 = new Phase(List.of(background1.getImage()), eventManager, 640, 520);

		phase1.add(player,true);

		Container container = new Container("game", 640, 520);

		container.addPhase(phase1);

		container.load();
	}

}