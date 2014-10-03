package samaritan;

import java.util.HashMap;
import java.util.Map;

import samaritan.affirm.Affirm;

@Immutable
public final class Primitives {

	private static final Map<Class<?>, Class<?>> WRAPPERS = new HashMap<>();

	static {
		WRAPPERS.put(boolean.class, Boolean.class);
		WRAPPERS.put(byte.class, Byte.class);
		WRAPPERS.put(short.class, Short.class);
		WRAPPERS.put(char.class, Character.class);
		WRAPPERS.put(int.class, Integer.class);
		WRAPPERS.put(long.class, Long.class);
		WRAPPERS.put(float.class, Float.class);
		WRAPPERS.put(double.class, Double.class);
	}

	public static Class<?> wrap(Class<?> type) {
		Affirm.notNull(type);

		return WRAPPERS.get(type);
	}

}