package samaritan.attribute;

import static samaritan.affirm.Affirm.notNull;

import java.util.HashMap;
import java.util.Map;

import samaritan.Immutable;
import samaritan.Nullable;

public final class AttributeMap {

	private final Map<AttributeKey<?>, Attribute<?>> attributes = new HashMap<>();

	@SuppressWarnings("unchecked")
	public <T> T get(AttributeKey<T> key) {
		if (contains(notNull(key))) {
			Attribute<T> attr = (Attribute<T>) attributes.get(key);
			return attr.getValue();
		}
		return setAndGet(key, key.getInitial());
	}

	public <T> T setAndGet(AttributeKey<T> key, @Nullable T value) {
		attributes.put(notNull(key), new Attribute<T>(key, value));
		return value;
	}

	public <T> T setIfAbsent(AttributeKey<T> key, @Nullable T value) {
		if (contains(key))
			return get(key);
		return setAndGet(key, value);
	}

	public <T> boolean contains(AttributeKey<T> key) {
		return attributes.containsKey(notNull(key));
	}

}
