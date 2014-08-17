package samaritan;

public interface Predicate<T> {

	boolean evaluate(@Nullable T input);

}