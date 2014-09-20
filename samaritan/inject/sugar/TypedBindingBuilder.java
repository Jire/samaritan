package samaritan.inject.sugar;

import samaritan.inject.Binder;

public abstract class TypedBindingBuilder<T> extends AbstractBindingBuilder {

	private final Class<? super T> type;

	protected TypedBindingBuilder(Binder binder, Class<? super T> type) {
		super(binder);
		this.type = type;
	}

	public final Class<? super T> getType() {
		return type;
	}

}