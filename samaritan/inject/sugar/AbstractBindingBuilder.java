package samaritan.inject.sugar;

import samaritan.inject.Binder;

public abstract class AbstractBindingBuilder implements BindingBuilder {

	private final Binder binder;

	protected AbstractBindingBuilder(Binder binder) {
		this.binder = binder;
	}

	@Override
	public final Binder getBinder() {
		return binder;
	}

}