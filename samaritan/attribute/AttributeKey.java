package samaritan.attribute;

import static samaritan.affirm.Affirm.notNull;
import samaritan.Nullable;

public final class AttributeKey<T> {

	private final String name;

	private final T initial;

	private AttributeKey(String name, @Nullable T initial) {
		this.name = notNull(name);
		this.initial = initial;
	}

	protected String getName() {
		return name;
	}

	protected T getInitial() {
		return initial;
	}

	public static <T> AttributeKey<T> valueOf(String name) {
		return valueOf(name, null);
	}

	public static <T> AttributeKey<T> valueOf(String name, @Nullable T initial) {
		return new AttributeKey<T>(name, initial);
	}

}