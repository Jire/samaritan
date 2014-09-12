package samaritan.inject;

public interface Injector {

	<T> T getInstance(Class<?> type);

	Binder getBinder();

}