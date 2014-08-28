package samaritan.affirm;

@FunctionalInterface
public interface Affirmative<T> {

	boolean affirm(T reference, Object... parameters);

}
