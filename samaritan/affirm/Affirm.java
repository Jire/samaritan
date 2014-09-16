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

	public static <T> T affirm(Affirmative<T> affirmative, T reference,
			Object... parameters) {
		if (!affirmative.affirm(reference, parameters))
			throw new IllegalStateException();
		return reference;
	}

	@SuppressWarnings("unchecked")
	public static <T> T notNull(T reference) {
		return (T) affirm(NOT_NULL, reference);
	}

	public static boolean truth(boolean reference) {
		return affirm(TRUTH, reference);
	}

	public static Number between(Number reference, Number first, Number last,
			Number... excluded) {
		return affirm(NUMBER_BETWEEN, reference, first, last, excluded);
	}

}