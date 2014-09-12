package samaritan.inject;

import java.util.function.Consumer;

public interface Binding extends Consumer<Binder> {

	<T> T get(T type);

}