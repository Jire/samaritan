package samaritan.event;

public final class EventAdmins {

	private static final EventAdmin DEFAULT = new DefaultEventAdmin();

	public static EventAdmin get() {
		return DEFAULT;
	}

}