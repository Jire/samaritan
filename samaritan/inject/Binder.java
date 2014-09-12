package samaritan.inject;

public interface Binder {

	void install(Module module);

	<B extends Binding> void bind(B binding);

	<B extends Binding, T> T get(B binding, T type);

}