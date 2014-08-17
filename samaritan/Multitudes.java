package samaritan;

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

}