package samaritan.event;

public interface EventAdmin {

	void register(EventListener listener);

	void dispatch(Event event);

}