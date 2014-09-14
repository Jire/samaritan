package samaritan.event;

import java.lang.reflect.Method;
import java.util.function.Predicate;

import samaritan.Immutable;

@Immutable
final class EventSubscriberPredicate implements Predicate<Method> {

	private static final int MINIMUM_PARAMETERS = 0, MAXIMUM_PARAMETERS = 2;

	private static final Predicate<Method> INSTANCE = new EventSubscriberPredicate();

	@Override
	public boolean test(Method t) {
		int params = t.getParameterCount();
		return t.isAnnotationPresent(EventSubscriber.class)
				&& params > MINIMUM_PARAMETERS && params <= MAXIMUM_PARAMETERS
				&& Event.class.isAssignableFrom(t.getParameterTypes()[0]);
	}

	public static Predicate<Method> get() {
		return INSTANCE;
	}

}