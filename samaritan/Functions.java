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

	public static class VarargsHelper<T> {

		private final T[] accepted;

		@SafeVarargs
		private VarargsHelper(T... accepted) {
			this.accepted = accepted;
		}

		public T[] done() {
			return accepted;
		}

		public VarargsHelper<T> add(@SuppressWarnings("unchecked") T... toAdd) {
			Affirm.notNull(toAdd);
			return new VarargsHelper<T>(appendEnd(accepted, toAdd));
		}

		public VarargsHelper<T> when(boolean condition) {
			return condition ? varargs(done())
					: new NoAddVarargsHelper<T>(this);
		}

		private static final class NoAddVarargsHelper<T> extends
				VarargsHelper<T> {

			private final VarargsHelper<T> helper;

			private NoAddVarargsHelper(VarargsHelper<T> helper) {
				this.helper = helper;
			}

			@Override
			public T[] done() {
				return helper.done();
			}

			@Override
			public VarargsHelper<T> add(
					@SuppressWarnings("unchecked") T... toAdd) {
				return this;
			}

			@Override
			public VarargsHelper<T> when(boolean condition) {
				return helper.when(condition);
			}

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