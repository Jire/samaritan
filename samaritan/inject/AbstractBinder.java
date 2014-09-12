package samaritan.inject;

import samaritan.affirm.Affirm;

public abstract class AbstractBinder implements Binder {

	@Override
	public final void install(Module module) {
		Affirm.notNull(module);
		module.configure(this);
	}

	@Override
	public <B extends Binding> void bind(B binding) {
		Affirm.notNull(binding);
		binding.accept(this);
	}

	@Override
	public <B extends Binding, T> T get(B binding, T type) {
		Affirm.notNull(binding);
		Affirm.notNull(type);

		return binding.get(type);
	}

}