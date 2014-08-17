package samaritan.affirm;

public interface Affirmative<T> {

	boolean affirm(T reference, Object... parameters);

}