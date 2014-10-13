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
	public static <T> Varargs<T> varargs(boolean condition, T... accepted) {
		Affirm.notNull(accepted);
		return new Varargs<T>(condition, accepted);
	}

	public static final class Varargs<T> {

		private final boolean condition;
		private final T[] accepted;

		@SafeVarargs
		private Varargs(boolean condition, T... accepted) {
			this.condition = condition;
			this.accepted = accepted;
		}

		public T[] pass(@SuppressWarnings("unchecked") T... checked) {
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