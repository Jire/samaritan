package samaritan.inject.sugar;

import samaritan.affirm.Affirm;
import samaritan.inject.Binder;
import samaritan.inject.Module;

public abstract class AbstractModule implements Module {

	private Binder binder;

	@Override
	public final void configure(Binder binder) {
		Affirm.notNull(binder);
		Affirm.truth(this.binder == null);

		try {
			configure();
		} finally {
			this.binder = binder;
		}
	}

	protected abstract void configure();

}