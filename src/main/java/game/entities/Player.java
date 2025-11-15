package game.entities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import com.google.common.eventbus.Subscribe;

import engine.entities.Entity;
import engine.entities.EntityProps;
import engine.event.Event;

public class Player extends Entity {

	private int speed = 7;

	private final Point dPosition = new Point(0, 0);

	private boolean up, down, left, right;


	public Player(final List<Image> resourcesSet, final EntityProps entityProps) {
		super(resourcesSet, entityProps);
	}


	@Subscribe
	public void listen(Event<KeyEvent> event) {

		switch (event.type()) {

			case KEY_PRESSED:
				keyPressed(event.value());
				break;
			case KEY_RELEASED:
				keyReleased(event.value());
				break;
		}
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(final int speed) {
		this.speed = speed;
	}


	@Override
	public void update() {
		dPosition.x = 0;
		dPosition.y = 0;

		if (up)    dPosition.y -= speed;
		if (down)  dPosition.y += speed;
		if (left)  dPosition.x -= speed;
		if (right) dPosition.x += speed;

		position.x += dPosition.x;
		position.y += dPosition.y;
	}


	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W -> up = true;
			case KeyEvent.VK_S -> down = true;
			case KeyEvent.VK_A -> left = true;
			case KeyEvent.VK_D -> right = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W -> up = false;
			case KeyEvent.VK_S -> down = false;
			case KeyEvent.VK_A -> left = false;
			case KeyEvent.VK_D -> right = false;
		}
	}


}