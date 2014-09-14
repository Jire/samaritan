package samaritan.inject;

public interface Binding<T> {

	Class<T> type();

	<R extends T> R get(Class<?> type);

}