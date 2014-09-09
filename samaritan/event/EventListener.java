package samaritan.event;

public interface EventListener {

	default void onRegister(EventAdmin admin) {
	}

	default void onReceive(Event event, EventAdmin admin) {
	}

}