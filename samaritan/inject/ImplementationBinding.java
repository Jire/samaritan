package samaritan.inject;

public final class ImplementationBinding<T> extends AbstractBinding<T> {

	private final Class<? extends T> implementation;

	public ImplementationBinding(Class<T> type,
			Class<? extends T> implementation) {
		super(type);
		this.implementation = implementation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <R> R get(Class<?> type) {
		return (R) implementation;
	}

}