package samaritan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import samaritan.affirm.Affirm;

@Immutable
public final class Primitives {

	/**
	 * A {@link Map} of boxed to un-boxed primitive types.
	 *
	 * <p>
	 * The entries within this map should <b>never</b> need to change,
	 * {@link #buildWrappers()} returns a
	 * {@link Collections#unmodifiableMap(Map) read-only map} which provides
	 * read-only access to this map, no entry altering operations (put, remove,
	 * etc) are allowed to be performed. Should they be an
	 * {@link UnsupportedOperationException} will occur.
	 * </p>
	 */
	private static final Map<Class<?>, Class<?>> WRAPPERS = buildWrappers();

	public static Class<?> wrap(Class<?> type) {
		Affirm.notNull(type);

		return WRAPPERS.get(type);
	}

	private static Map<Class<?>, Class<?>> buildWrappers() {
		Map<Class<?>, Class<?>> wrappers = new HashMap<>();
		wrappers.put(boolean.class, Boolean.class);
		wrappers.put(byte.class, Byte.class);
		wrappers.put(short.class, Short.class);
		wrappers.put(char.class, Character.class);
		wrappers.put(int.class, Integer.class);
		wrappers.put(long.class, Long.class);
		wrappers.put(float.class, Float.class);
		wrappers.put(double.class, Double.class);
		return Collections.unmodifiableMap(wrappers);
	}

}