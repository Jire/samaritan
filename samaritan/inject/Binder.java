package samaritan.inject;

import samaritan.affirm.Affirm;

public interface Binder {

	void bind(Binding<?> binding);

	<T, R extends T> R get(Class<T> type);

	default void install(Module module) {
		Affirm.notNull(module);
		module.configure(this);
	}

}