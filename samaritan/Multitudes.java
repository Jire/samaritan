package samaritan;

import static java.util.Arrays.asList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Immutable
public final class Multitudes {

	private Multitudes() {
		Objects.notConstructable();
	}

	public static <T> boolean contains(T[] array, T reference) {
		for (T element : array)
			if (reference.equals(element))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] copyOf(T[] array, int start, int end) {
		Object[] values = new Object[end - start];
		for (int i = 0; i < (end - start); i++)
			values[i] = array[start + i];
		return (T[]) values;
	}

	public static <T> T[] valuesAfter(T[] array, int index) {
		return copyOf(array, index, array.length);
	}

	public static <T> T[] valuesBefore(T[] array, int index) {
		return copyOf(array, 0, index);
	}

	public static <T> T[] appendEnd(T[] array, Object... values) {
		return insert(array, array.length, values);
	}

	public static <T> T[] appendStart(T[] array, Object... values) {
		return insert(array, 0, values);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] insert(T[] array, int start, Object... values) {
		return (T[]) concat(concat(of(valuesBefore(array, start)), of(values)), of(valuesAfter(array, start))).toArray(Object[]::new);
	}

	public static <K> Map<K, List<K>> asMap(K[][] array) {
		Map<K, List<K>> map = new HashMap<>(array.length);
		for (K[] k : array)
			map.put(k[0], asList(valuesAfter(k, 1)));
		return map;
	}

}
