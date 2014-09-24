package samaritan;

import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;
import static java.util.Arrays.asList;

@Immutable
public final class Multitudes {

	private Multitudes() {
		Objects.notConstructable();
	}

	public static final <T> boolean contains(T[] array, T reference) {
		for (T element : array)
			if (reference.equals(element))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public static final <T> T[] copyOf(T[] array, int start, int end) {
		Object[] values = new Object[end - start];
		for (int i = 0; i < (end - start); i++)
			values[i] = array[start + i];
		return (T[]) values;
	}

	public static final <T> T[] valuesAfter(T[] array, int index) {
		return copyOf(array, index, array.length);
	}

	public static final <T> T[] valuesBefore(T[] array, int index) {
		return copyOf(array, 0, index);
	}

	public static final <T> T[] appendEnd(T[] array, Object... values) {
		return insert(array, array.length, values);
	}

	public static final <T> T[] appendStart(T[] array, Object... values) {
		return insert(array, 0, values);
	}

	@SuppressWarnings("unchecked")
	public static final <T> T[] insert(T[] array, int start, Object... values) {
		return (T[]) concat(concat(of(valuesBefore(array, start)), of(values)), of(valuesAfter(array, start))).toArray(Object[]::new);
	}
	
	public static <K> Map<K, List<K>> asMap(K[][] array) {
		Map<K, List<K>> map = new HashMap<>(array.length);
		for (K[] k : array)
			map.put(k[0], (List<K>) asList(valuesAfter(k, 1)));
		return map;
	}

}
