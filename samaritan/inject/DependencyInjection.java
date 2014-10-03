package samaritan.inject;

import static java.util.stream.Stream.of;
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
		of(modules).forEach(binder::install);
		return new DefaultInjector(binder, modules);
	}

}