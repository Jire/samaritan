package samaritan.affirm;

import samaritan.Immutable;

@Immutable
final class TruthAffirmative implements Affirmative<Boolean> {

	@Override
	public boolean affirm(Boolean reference, Object... values) {
		return reference;
	}

}