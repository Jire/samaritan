package samaritan.inject.sugar;

import java.lang.annotation.Annotation;

import samaritan.inject.Binder;
import samaritan.inject.ConstantBinding;

final class ConstantBindingBuilder<T> extends TypedBindingBuilder<T> {

	private final T value;

	ConstantBindingBuilder(Binder binder, Class<T> type, T value) {
		super(binder, type);
		this.value = value;
	}

	public void with(Class<? extends Annotation> annotation) {
		getBinder().bind(new ConstantBinding<T>(getType(), value, annotation));
	}

}