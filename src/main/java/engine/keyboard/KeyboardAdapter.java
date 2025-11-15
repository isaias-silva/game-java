package engine.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import engine.event.Event;
import engine.event.EventManager;
import engine.event.Events;

public class  KeyboardAdapter extends KeyAdapter {
	private final EventManager eventManager;

	public KeyboardAdapter(EventManager evManager){
		eventManager = evManager;

	}


		@Override
		public void keyPressed(KeyEvent e) {
		eventManager.emit(new Event<KeyEvent>(Events.KEY_PRESSED, e));
			super.keyPressed(e);

		}

		@Override
		public void keyReleased(KeyEvent e) {
			eventManager.emit(new Event<KeyEvent>(Events.KEY_RELEASED, e));
			super.keyReleased(e);
		}
	}