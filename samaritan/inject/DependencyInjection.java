package samaritan.inject;

import java.util.stream.Stream;

import samaritan.Immutable;
import samaritan.Objects;

@Immutable
public final class DependencyInjection {

	private DependencyInjection() {
		Objects.notConstructable();
	}

	public static Injector createInjector() {
		return createInjector(binder -> {});
	}

	public static Injector createInjector(Module... modules) {
		Binder binder = new DefaultBinder();
		Stream.of(modules).forEach(module -> binder.install(module));
		return new DefaultInjector(binder, modules);
	}

}