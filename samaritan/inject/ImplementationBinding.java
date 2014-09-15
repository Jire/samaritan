package samaritan.inject;

import samaritan.Immutable;

@Immutable
public final class ImplementationBinding<T> extends AbstractBinding<T> {

	private final Class<? extends T> implementation;

	public ImplementationBinding(Class<T> type,
			Class<? extends T> implementation) {
		super(type);
		this.implementation = implementation;
	}

	public ImplementationBinding(Class<T> type) {
		this(type, type);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <R extends T> R get(Class<?> type) {
		return (R) implementation;
	}

}