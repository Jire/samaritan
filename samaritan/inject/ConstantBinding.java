package samaritan.inject;

import java.lang.annotation.Annotation;

import samaritan.Immutable;

@Immutable
public final class ConstantBinding<T> extends AbstractBinding<T> {

	private final T value;
	private final Class<? extends Annotation> annotation;

	public ConstantBinding(Class<T> type, T value,
			Class<? extends Annotation> annotation) {
		super(type);
		this.value = value;
		this.annotation = annotation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <R extends T> R get(Class<?> type) {
		return (R) value;
	}

}