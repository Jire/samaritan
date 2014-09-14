package samaritan.inject;

import samaritan.Immutable;
import samaritan.Objects;

@Immutable
public final class DependencyInjection {
	
	private DependencyInjection() {
		Objects.notConstructable();
	}

	private static final Module DUMMY_MODULE = binder -> {};

	public static Injector createInjector() {
		return createInjector(DUMMY_MODULE);
	}

	public static Injector createInjector(Module... modules) {
		Binder binder = new DefaultBinder();
		for (Module module : modules)
			binder.install(module);
		return new DefaultInjector(binder, modules);
	}

}