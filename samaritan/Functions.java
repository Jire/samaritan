package samaritan;

import static samaritan.Multitudes.appendEnd;

import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

import samaritan.affirm.Affirm;

@Immutable
@Experimental
public final class Functions {

	private Functions() {
		Objects.notConstructable();
	}

	@SafeVarargs
	public static <T> VarargsHelper<T> varargs(T... accepted) {
		return new VarargsHelper<T>(Affirm.notNull(accepted));
	}

	public static final class VarargsHelper<T> {

		private final T[] accepted;

		@SafeVarargs
		private VarargsHelper(T... accepted) {
			this.accepted = accepted;
		}

		public T[] pass() {
			return accepted;
		}

		public T[] pass(boolean condition,
				@SuppressWarnings("unchecked") T... checked) {
			Affirm.notNull(checked);
			return condition ? (T[]) appendEnd(accepted, checked)
					: (T[]) accepted;
		}

	}

	public static <T> void setAll(T[] array,
			IntFunction<? extends T> generator, int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment)
			array[i] = generator.apply(i);
	}

	public static void setAll(int[] array, IntUnaryOperator generator,
			int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment)
			array[i] = generator.applyAsInt(i);
	}

	public static void setAll(long[] array, IntToLongFunction generator,
			int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment)
			array[i] = generator.applyAsLong(i);
	}

	public static void setAll(double[] array, IntToDoubleFunction generator,
			int increment) {
		Affirm.notNull(generator);

		for (int i = 0; i < array.length; i += increment)
			array[i] = generator.applyAsDouble(i);
	}

}