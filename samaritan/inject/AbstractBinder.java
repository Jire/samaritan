package samaritan.inject;

import java.util.HashMap;
import java.util.Map;

import samaritan.affirm.Affirm;

abstract class AbstractBinder implements Binder {

	private final Map<Class<?>, Binding<?>> bindings = new HashMap<>();

	@Override
	public void bind(Binding<?> binding) {
		Affirm.notNull(binding);
		bindings.put(binding.type(), binding);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T, R extends T> R get(Class<T> type) {
		Affirm.notNull(type);
		return (R) bindings.get(type).get(type);
	}

}