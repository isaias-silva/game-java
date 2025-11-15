package engine.entities;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public abstract class Entity {

	protected Point position;

	protected int width;

	protected int height;

	protected final List<Image> resources;

	private int mainResource = 0;

	private final UUID id;


	protected Entity(List<Image> resourcesSet, EntityProps entityProps) {
		resources = resourcesSet;
		position = new Point();
		position.setLocation(entityProps.position());

		width = entityProps.width();
		height = entityProps.height();
		id = UUID.randomUUID();

	}

	public void update() {

	}

	protected void setResources(int index) {
		mainResource = index;
	}


	public Image getSprite() {

		return resources.get(mainResource);
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	public UUID getId() {
		return id;
	}


	public Point getPosition() {
		return position;
	}


	public void setPosition(final Point position) {
		this.position = position;
	}
}