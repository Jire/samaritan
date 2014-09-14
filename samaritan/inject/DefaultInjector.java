package samaritan.inject;

public final class DefaultInjector extends AbstractInjector {

	public DefaultInjector(Binder binder, Module... modules) {
		super(binder, modules);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getInstance(Class<? extends T> type) {
		try {
			return ((Class<? extends T>) getBinder().get(type)).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e); // delegate
		}
	}

}