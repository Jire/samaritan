package samaritan.affirm;

import samaritan.Immutable;
import samaritan.Multitudes;

@Immutable
final class NumberBetweenAffirmative implements Affirmative<Number> {

	@Override
	public boolean affirm(Number reference, Object... values) {
		double value = reference.doubleValue();
		double first = ((Number) values[0]).doubleValue();
		double last = ((Number) values[1]).doubleValue();
		Number[] excluded = (Number[]) values[2];
		return Multitudes.contains(excluded, value)
				|| (value >= first && value <= last);
	}

}