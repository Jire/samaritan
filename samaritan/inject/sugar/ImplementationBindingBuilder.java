package samaritan.inject.sugar;

import samaritan.affirm.Affirm;
import samaritan.inject.Binder;
import samaritan.inject.ImplementationBinding;

public final class ImplementationBindingBuilder<T> extends
		TypedBindingBuilder<T> {

	ImplementationBindingBuilder(Binder binder, Class<T> type) {
		super(binder, type);
	}

	public void to(Class<? extends T> implementation) {
		Affirm.notNull(implementation);
		getBinder().bind(
				new ImplementationBinding<T>(getType(), implementation));
	}

	public void toSelf() {
		getBinder().bind(new ImplementationBinding<T>(getType()));
	}

}