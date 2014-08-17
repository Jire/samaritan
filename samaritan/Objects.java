package samaritan;

import static java.lang.String.format;
import samaritan.affirm.Affirm;

@Immutable
public final class Objects {

	private Objects() {
		notConstructable();
	}

	public static void notConstructable() {
		throw new UnsupportedOperationException();
	}

	public static void notConstructable(String message, Object... messageArgs) {
		throw new UnsupportedOperationException(format(message, messageArgs));
	}

	@SafeVarargs
	public static <T> T firstNonNull(T... items) {
		Affirm.notNull(items);
		Affirm.truth(items.length > 0);

		for (T item : items)
			if (item != null)
				return item;

		throw new NullPointerException();
	}

	public static boolean equal(@Nullable Object first, @Nullable Object second) {
		return (first == null && second == null)
				|| (first != null && second != null && first.equals(second));
	}

}