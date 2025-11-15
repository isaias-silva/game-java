package engine.phases;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import engine.entities.Entity;
import engine.event.EventManager;
import engine.keyboard.KeyboardAdapter;

public class Phase extends JPanel {

	private final EventManager eventManager;

	private final List<Image> resources;

	private final Set<Entity> entities;

	private int mainResource = 0;

	private ScheduledExecutorService executor;


	public Phase(List<Image> resourcesList, EventManager manager, int width, int height) {
		resources = resourcesList;
		eventManager = manager;
		entities = new HashSet<>();
		addKeyListener(new KeyboardAdapter(manager));
		setFocusable(true);
		setSize(width, height);

	}


	public void add(Entity entity, boolean listenEvent) {
		if (listenEvent) {
			eventManager.register(entity);
		}
		entities.add(entity);
	}


	public void remove(UUID entityId) {

		entities.removeIf(e -> e.getId().equals(entityId));
	}


	public void changeResource(int index) {
		mainResource = resources.size() > index ? 0 : index;
	}


	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.drawImage(resources.get(mainResource), 0, 0, getWidth(), getHeight(), null);

		entities.forEach(
			e -> graphics2D.drawImage(e.getSprite(), e.getPosition().x, e.getPosition().y, e.getWidth(), e.getHeight(),
				this));


	}


	public void loop() {
		entities.forEach(Entity::update);
		SwingUtilities.invokeLater(this::repaint);
	}


	public void start() {
		if (executor != null) {
			return;
		}
		executor = Executors.newSingleThreadScheduledExecutor() ;

		executor.scheduleAtFixedRate(this::loop, 0, 30, TimeUnit.MILLISECONDS);
	}


	public void end() {
		executor.shutdown();
	}
}