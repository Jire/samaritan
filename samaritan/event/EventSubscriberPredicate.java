package samaritan.event;

import java.lang.reflect.Method;
import java.util.function.Predicate;

import samaritan.Immutable;

@Immutable
final class EventSubscriberPredicate implements Predicate<Method> {

	private static final Predicate<Method> INSTANCE = new EventSubscriberPredicate();

	@Override
	public boolean test(Method t) {
		return t.getParameterTypes().length == 1
				&& t.isAnnotationPresent(EventSubscriber.class)
				&& Event.class.isAssignableFrom(t.getParameterTypes()[0]);
	}

	public static Predicate<Method> get() {
		return INSTANCE;
	}

}