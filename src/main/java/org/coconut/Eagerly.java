package org.coconut;

import org.coconut.functor.predicate.UnaryPredicate;

import static org.coconut.Iterators.asIterable;

import java.util.Comparator;
import java.util.Iterator;

import org.coconut.functor.function.BinaryFunction;

public class Eagerly {
  private Eagerly() {
  }

  private static <T> boolean comb(Iterable<T> c, UnaryPredicate<? super T> p, boolean shortcut) {
    for (T t : c)
      if (p.test(t) == shortcut)
        return shortcut;
    return !shortcut;
  }

  public static <T> boolean anyof(Iterable<? extends T> c, UnaryPredicate<? super T> p) {
    return comb(c, p, true);
  }

  public static <T> boolean allof(Iterable<? extends T> c, UnaryPredicate<? super T> p) {
    return comb(c, p, false);
  }

  public static <T> boolean noneof(Iterable<? extends T> c, UnaryPredicate<? super T> p) {
    return !anyof(c, p);
  }

  public static <S, T> T reduce(Iterable<? extends S> c, BinaryFunction<T, ? super S, T> f, T init) {
    T accumulator = init;
    for (S elem : c) {
      accumulator = f.apply(accumulator, elem);
    }
    return accumulator;
  }

  public static <T> T reduce(Iterable<? extends T> c, BinaryFunction<T, ? super T, T> f) {
    Iterator<? extends T> iterator = c.iterator();
    T first = iterator.next();
    Iterable<? extends T> rest = asIterable(iterator);
    return reduce(rest, f, first);
  }

  public static <T> T max(Iterable<T> iterable, Comparator<? super T> c) {
    return reduce(iterable, (max, elem) -> c.compare(elem, max) > 0 ? elem : max);
  }

  public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) {
    return reduce(iterable, (max, elem) -> elem.compareTo(max) > 0 ? elem : max);
  }

  public static <T> T min(Iterable<T> iterable, Comparator<? super T> c) {
    return reduce(iterable, (min, elem) -> c.compare(elem, min) < 0 ? elem : min);
  }

  public static <T extends Comparable<? super T>> T min(Iterable<T> iterable) {
    return reduce(iterable, (min, elem) -> elem.compareTo(min) < 0 ? elem : min);
  }
}