package samaritan.inject;

public interface Binding<T> {

	Class<T> type();

	<R> R get(Class<?> type);

}