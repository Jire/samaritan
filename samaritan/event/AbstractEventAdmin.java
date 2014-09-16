package samaritan.event;

import static java.util.Optional.ofNullable;
import static java.util.stream.Stream.of;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import samaritan.affirm.Affirm;

public abstract class AbstractEventAdmin implements EventAdmin {

	private final Map<Class<? extends Event>, Map<Method, EventListener>> events = new HashMap<>();

	@Override
	@SuppressWarnings("unchecked")
	public final void register(EventListener listener) {
		Affirm.notNull(listener);

		of(listener.getClass().getMethods())
				.filter(EventSubscriberPredicate.get())
				.forEach(method -> {
					Class<? extends Event> event = (Class<? extends Event>)
													method.getParameterTypes()[0];
					Map<Method, EventListener> methods = ofNullable(
							events.get(event)).orElse(new HashMap<>());
					methods.put(method, listener);
					method.setAccessible(true);
					events.put(event, methods);
				});
	}

	@Override
	public final void dispatch(Event event) {
		Affirm.notNull(event);

		// Parallel stream was either a great idea or a terrible one
		events.get(event.getClass()).entrySet().parallelStream()
				.forEach(pair -> {
					try {
						Method method = pair.getKey();
						EventListener listener = pair.getValue();
						
						if (method.getParameterCount() == 2)
							method.invoke(listener, event, listener);
						else
							method.invoke(listener, event);
					} catch (Exception e) {
						// Still delegating... find a better solution
						throw new RuntimeException(e);
					}
				});
	}

}