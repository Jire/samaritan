package samaritan.event;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractEventAdmin implements EventAdmin {

	private final Set<EventListener> listeners;

	private AbstractEventAdmin(Set<EventListener> listeners) {
		this.listeners = listeners;
	}

	protected AbstractEventAdmin() {
		this(new HashSet<EventListener>());
	}

	@Override
	public final void register(EventListener listener) {
		listeners.add(listener);
		listener.onRegister(this);
	}

}