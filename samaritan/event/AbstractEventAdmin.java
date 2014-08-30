package samaritan.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import samaritan.affirm.Affirm;

public abstract class AbstractEventAdmin implements EventAdmin {

	private final Map<Method, EventListener> registry = new HashMap<>();

	@Override
	public final void register(EventListener listener) {
		Affirm.notNull(listener);

		Stream<Method> methods = Stream.of(listener.getClass().getMethods());
		methods.filter(EventSubscriberPredicate.get()).forEach(
				(m) -> registry.put(m, listener));

		listener.onRegister(this);

		onRegister(listener);
	}

	@Override
	public final void dispatch(Event event) {
		Affirm.notNull(event);

		// Parallel stream was either a great idea or a terrible one
		registry.entrySet().parallelStream().forEach((pair) -> {
			try {
				Method method = pair.getKey();
				EventListener listener = pair.getValue();

				method.setAccessible(true);
				method.invoke(listener, event);

				listener.onReceive(event, this);
			} catch (Exception e) {
				// Still delegating... find a better solution
				throw new RuntimeException(e);
			}
		});

		onDispatch(event);
	}

	protected void onRegister(EventListener listener) {
	}

	protected void onDispatch(Event event) {
	}

}