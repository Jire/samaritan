package samaritan.inject.sugar;

import samaritan.inject.Binder;

public abstract class TypedBindingBuilder<T> extends AbstractBindingBuilder {

	private final Class<T> type;

	protected TypedBindingBuilder(Binder binder, Class<T> type) {
		super(binder);
		this.type = type;
	}

	public final Class<T> getType() {
		return type;
	}

}