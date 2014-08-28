package samaritan;

@FunctionalInterface
public interface Predicate<T> {

	boolean evaluate(@Nullable T input);

}
