package samaritan.inject;

import java.util.stream.Stream;

public interface Injector {

	Binder getBinder();
	
	Stream<Module> getModules();

	<T> T getInstance(Class<? extends T> type);

}