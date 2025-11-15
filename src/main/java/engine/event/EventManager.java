package engine.event;

import com.google.common.eventbus.EventBus;

import engine.entities.Entity;

public class EventManager {

	private final EventBus eventBus;


	public EventManager(final EventBus event) {
		eventBus = event;
	}

	public void emit(Event<?> event){

		eventBus.post(event);
	}
	public void register(Entity entity){
		eventBus.register(entity);
	}

}