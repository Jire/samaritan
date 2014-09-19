package samaritan.streams;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public abstract class BackedStream<T> implements Stream<T> {

	private final Stream<T> backing;

	public BackedStream(Stream<T> stream) {
		this.backing = stream;
	}

	@Override
	public Iterator<T> iterator() {
		return backing.iterator();
	}

	@Override
	public Spliterator<T> spliterator() {
		return backing.spliterator();
	}

	@Override
	public boolean isParallel() {
		return backing.isParallel();
	}

	@Override
	public Stream<T> sequential() {
		return backing.sequential();
	}

	@Override
	public Stream<T> parallel() {
		return backing.parallel();
	}

	@Override
	public Stream<T> unordered() {
		return backing.unordered();
	}

	@Override
	public Stream<T> onClose(Runnable closeHandler) {
		return backing.onClose(closeHandler);
	}

	@Override
	public void close() {
		backing.close();
	}

	@Override
	public Stream<T> filter(Predicate<? super T> predicate) {
		return backing.filter(predicate);
	}

	@Override
	public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
		return backing.map(mapper);
	}

	@Override
	public IntStream mapToInt(ToIntFunction<? super T> mapper) {
		return backing.mapToInt(mapper);
	}

	@Override
	public LongStream mapToLong(ToLongFunction<? super T> mapper) {
		return backing.mapToLong(mapper);
	}

	@Override
	public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
		return backing.mapToDouble(mapper);
	}

	@Override
	public <R> Stream<R> flatMap(
			Function<? super T, ? extends Stream<? extends R>> mapper) {
		return backing.flatMap(mapper);
	}

	@Override
	public IntStream flatMapToInt(
			Function<? super T, ? extends IntStream> mapper) {
		return backing.flatMapToInt(mapper);
	}

	@Override
	public LongStream flatMapToLong(
			Function<? super T, ? extends LongStream> mapper) {
		return backing.flatMapToLong(mapper);
	}

	@Override
	public DoubleStream flatMapToDouble(
			Function<? super T, ? extends DoubleStream> mapper) {
		return backing.flatMapToDouble(mapper);
	}

	@Override
	public Stream<T> distinct() {
		return backing.distinct();
	}

	@Override
	public Stream<T> sorted() {
		return backing.sorted();
	}

	@Override
	public Stream<T> sorted(Comparator<? super T> comparator) {
		return backing.sorted(comparator);
	}

	@Override
	public Stream<T> peek(Consumer<? super T> action) {
		return backing.peek(action);
	}

	@Override
	public Stream<T> limit(long maxSize) {
		return backing.limit(maxSize);
	}

	@Override
	public Stream<T> skip(long n) {
		return backing.skip(n);
	}

	@Override
	public void forEach(Consumer<? super T> action) {
		backing.forEach(action);
	}

	@Override
	public void forEachOrdered(Consumer<? super T> action) {
		backing.forEachOrdered(action);
	}

	@Override
	public Object[] toArray() {
		return backing.toArray();
	}

	@Override
	public <A> A[] toArray(IntFunction<A[]> generator) {
		return backing.toArray(generator);
	}

	@Override
	public T reduce(T identity, BinaryOperator<T> accumulator) {
		return backing.reduce(identity, accumulator);
	}

	@Override
	public Optional<T> reduce(BinaryOperator<T> accumulator) {
		return backing.reduce(accumulator);
	}

	@Override
	public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator,
			BinaryOperator<U> combiner) {
		return backing.reduce(identity, accumulator, combiner);
	}

	@Override
	public <R> R collect(Supplier<R> supplier,
			BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
		return backing.collect(supplier, accumulator, combiner);
	}

	@Override
	public <R, A> R collect(Collector<? super T, A, R> collector) {
		return backing.collect(collector);
	}

	@Override
	public Optional<T> min(Comparator<? super T> comparator) {
		return backing.min(comparator);
	}

	@Override
	public Optional<T> max(Comparator<? super T> comparator) {
		return backing.max(comparator);
	}

	@Override
	public long count() {
		return backing.count();
	}

	@Override
	public boolean anyMatch(Predicate<? super T> predicate) {
		return backing.anyMatch(predicate);
	}

	@Override
	public boolean allMatch(Predicate<? super T> predicate) {
		return backing.allMatch(predicate);
	}

	@Override
	public boolean noneMatch(Predicate<? super T> predicate) {
		return backing.noneMatch(predicate);
	}

	@Override
	public Optional<T> findFirst() {
		return backing.findFirst();
	}

	@Override
	public Optional<T> findAny() {
		return backing.findAny();
	}

}