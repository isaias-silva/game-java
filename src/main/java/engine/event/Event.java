package engine.event;

public record Event<T>(Events type, T value) {

}