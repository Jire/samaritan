package samaritan.event;

import static java.util.stream.Stream.of;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import samaritan.affirm.Affirm;

public abstract class AbstractEventAdmin implements EventAdmin {

	private final Map<Class<? extends Event>, Map<Method, EventListener>> events = new HashMap<>();

	protected final Map<Class<? extends Event>, Map<Method, EventListener>> getEvents() {
		return events;
	}

	protected abstract boolean isMethodValid(Method method);

	protected abstract Consumer<? super Method> registerAction(
			EventListener listener);

	protected abstract Consumer<? super Entry<Method, EventListener>> dispatchAction(
			Event event);

	@Override
	public final void register(EventListener listener) {
		Affirm.notNull(listener);

		of(listener.getClass().getMethods())
				.filter(this::isMethodValid)
				.forEach(registerAction(listener));
	}

	@Override
	public final void dispatch(Event event) {
		Affirm.notNull(event);

		// Parallel stream was either a great idea or a terrible one
		getEvents().get(event.getClass())
				.entrySet().parallelStream()
				.forEach(dispatchAction(event));
	}

}