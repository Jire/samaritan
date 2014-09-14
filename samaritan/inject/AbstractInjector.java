package samaritan.inject;

import java.util.stream.Stream;

public abstract class AbstractInjector implements Injector {

	private final Binder binder;
	private final Module[] modules;

	protected AbstractInjector(Binder binder, Module[] modules) {
		this.binder = binder;
		this.modules = modules;
	}

	@Override
	public final Binder getBinder() {
		return binder;
	}

	@Override
	public Stream<Module> getModules() {
		return Stream.of(modules);
	}

}