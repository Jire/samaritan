package samaritan.affirm;

import samaritan.Immutable;
import samaritan.Objects;

@Immutable
public final class Affirm {

	private Affirm() {
		Objects.notConstructable();
	}

	private static final Affirmative<Object> NOT_NULL = new NotNullAffirmative<>();
	private static final Affirmative<Boolean> TRUTH = new TruthAffirmative();
	private static final Affirmative<Number> NUMBER_BETWEEN = new NumberBetweenAffirmative();

	public static <T> void affirm(Affirmative<T> affirmative, T reference,
			Object... parameters) {
		if (!affirmative.affirm(reference, parameters))
			throw new IllegalStateException();
	}

	public static <T> void notNull(T reference) {
		affirm(NOT_NULL, reference);
	}

	public static void truth(boolean reference) {
		affirm(TRUTH, reference);
	}

	public static void between(Number reference, Number first, Number last,
			Number... excluded) {
		affirm(NUMBER_BETWEEN, reference, first, last, excluded);
	}

}