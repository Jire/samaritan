package samaritan.inject;

public final class ConstantBinding<T> extends AbstractBinding<T> {
	
	private final T value;

	public ConstantBinding(Class<T> type, T value) {
		super(type);
		this.value = value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <R> R get(Class<?> type) {
		return (R) value;
	}

}