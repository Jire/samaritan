package samaritan;

import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

import samaritan.affirm.Affirm;

@Immutable
@Experimental
public final class Functions {

	public static <T> void setAll(T[] array, IntFunction<? extends T> generator, int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment) {
			array[i] = generator.apply(i);
		}
	}

	public static void setAll(int[] array, IntUnaryOperator generator, int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment) {
			array[i] = generator.applyAsInt(i);
		}
	}

	public static void setAll(long[] array, IntToLongFunction generator, int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment) {
			array[i] = generator.applyAsLong(i);
		}
	}

	public static void setAll(double[] array, IntToDoubleFunction generator, int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment) {
			array[i] = generator.applyAsDouble(i);
		}
	}

	private Functions() {
		Objects.notConstructable();
	}

}