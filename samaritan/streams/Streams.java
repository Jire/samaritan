package samaritan.streams;

import java.util.stream.Stream;

import samaritan.Objects;

public final class Streams {

	private Streams() {
		Objects.notConstructable();
	}

	public static final <T> EnhancedStream<T> enhance(Stream<T> stream) {
		return EnhancedStream.of(stream);
	}

}