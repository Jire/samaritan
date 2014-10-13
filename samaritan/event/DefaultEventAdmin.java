package samaritan.event;

import static java.util.Optional.ofNullable;
import static samaritan.Functions.varargs;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

public final class DefaultEventAdmin extends AbstractEventAdmin {

	private static final int MINIMUM_PARAMETERS = 0, MAXIMUM_PARAMETERS = 2;

	@Override
	protected boolean isMethodValid(Method method) {
		int params = method.getParameterCount();
		return method.isAnnotationPresent(EventSubscriber.class)
				&& params > MINIMUM_PARAMETERS && params <= MAXIMUM_PARAMETERS
				&& Event.class.isAssignableFrom(method.getParameterTypes()[0]);
	}

	@Override
	protected Consumer<? super Method> registerAction(EventListener listener) {
		return method -> {
			@SuppressWarnings("unchecked")
			Class<? extends Event> event = (Class<? extends Event>) method
					.getParameterTypes()[0];
			Map<Method, EventListener> methods = ofNullable(
					getEvents().get(event)).orElse(new HashMap<>());
			methods.put(method, listener);
			method.setAccessible(true);

			getEvents().put(event, methods);
		};
	}

	@Override
	protected Consumer<? super Entry<Method, EventListener>> dispatchAction(
			Event event) {
		return pair -> {
			try {
				Method method = pair.getKey();
				EventListener listener = pair.getValue();
				varargs(1, 2, 3).add();
				method.invoke(varargs(listener, event).when(
						method.getParameterCount() == 2, listener).done());
			} catch (Exception e) {
				// Still delegating... find a better solution
				throw new RuntimeException(e);
			}
		};
	}

}