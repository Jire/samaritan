package samaritan.streams;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class EnhancedStream<T> extends BackedStream<T> {

	private EnhancedStream(Stream<T> stream) {
		super(stream);
	}

	static <T> EnhancedStream<T> of(Stream<T> stream) {
		return new EnhancedStream<T>(stream);
	}
	
	public void $forEach($Consumer<? super T> action) {
		super.forEach(action);
		Iterator<T> it = iterator();
		while (it.hasNext())
			if (action.$accept(it.next()))
				break;
	}
	
	public static abstract class $Consumer<T> implements Consumer<T> {
		
		private volatile boolean returned;
		private volatile boolean continued;
		
		protected final void $return() {
			returned = true;
		}
		
		protected final void $continue() {
			continued = true;
		}
		
		public final boolean $accept(T t) {
			if (returned)
				return true;
			if (continued)
				return continued = false;
			accept(t);
			return false;
		}
		
	}

}