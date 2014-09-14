package samaritan.inject;

@FunctionalInterface
public interface Module {

	void configure(Binder binder);
	
}