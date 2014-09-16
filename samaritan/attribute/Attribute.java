package samaritan.attribute;

import static samaritan.affirm.Affirm.notNull;
import samaritan.Immutable;
import samaritan.Nullable;

@Immutable
final class Attribute<T> {

	private final AttributeKey<T> key;

	private final T value;

	protected Attribute(AttributeKey<T> key, @Nullable T value) {
		this.key = notNull(key);
		this.value = value;
	}

	protected AttributeKey<T> getKey() {
		return key;
	}

	protected T getValue() {
		return value;
	}

}