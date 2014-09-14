package samaritan.inject;

public abstract class AbstractBinding<T> implements Binding<T> {

	private final Class<T> type;

	protected AbstractBinding(Class<T> type) {
		this.type = type;
	}

	@Override
	public final Class<T> type() {
		return type;
	}

}