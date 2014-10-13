package samaritan.inject.sugar;

import samaritan.affirm.Affirm;
import samaritan.inject.Binder;
import samaritan.inject.Module;

public abstract class AbstractModule implements Module {

	private Binder binder;

	@Override
	public final void configure(Binder binder) {
		Affirm.notNull(binder);
		Affirm.truth(this.binder == null);

		try {
			configure();
		} finally {
			this.binder = binder;
		}
	}

	protected final Binder getBinder() {
		return Affirm.notNull(binder);
	}

	protected abstract void configure();

	public final <T> ImplementationBindingBuilder<T> bind(Class<T> type) {
		Affirm.notNull(type);
		return new ImplementationBindingBuilder<T>(getBinder(), type);
	}

	@SuppressWarnings("unchecked")
	public final <T> ConstantBindingBuilder<T> bind(T value) {
		Affirm.notNull(value);
		return new ConstantBindingBuilder<T>(getBinder(),
				(Class<T>) value.getClass(), value);
	}

}