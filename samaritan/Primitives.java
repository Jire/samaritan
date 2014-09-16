package samaritan;

import java.util.HashMap;
import java.util.Map;

public final class Primitives {

	private final static Map<Class<?>, Class<?>> wrappers = new HashMap<Class<?>, Class<?>>();
	
	static {
	    wrappers.put(boolean.class, Boolean.class);
	    wrappers.put(byte.class, Byte.class);
	    wrappers.put(short.class, Short.class);
	    wrappers.put(char.class, Character.class);
	    wrappers.put(int.class, Integer.class);
	    wrappers.put(long.class, Long.class);
	    wrappers.put(float.class, Float.class);
	    wrappers.put(double.class, Double.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> Class<T> wrap(Class<T> type) {
		return (Class<T>) wrappers.get(type);
	}
	
}