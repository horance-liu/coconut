package org.coconut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.coconut.functor.function.UnaryFunction;

public final class Iterators {
  private Iterators() {
  }

  public static <T> Iterator<T> emptyIterator() {
    return Collections.<T>emptyList().iterator();
  }

  public static <T> Iterable<T> asIterable(Iterator<T> iterator) {
    return () -> iterator;
  }

  public static <T> List<T> asList(Iterator<? extends T> iterator) {
    List<T> list = new ArrayList<T>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    return list;
  }

  public static <T> Set<T> asSet(Iterator<? extends T> iterator) {
    return new LinkedHashSet<T>(asList(iterator));
  }

  public static <T> UnaryFunction<? super Iterable<? extends T>, Iterator<? extends T>> iterableToIterator() {
    return iterable -> iterable.iterator();
  }

  public static <T> UnaryFunction<? super Iterable<? extends T>, Iterator<? extends T>> iterableToIterator(Class<T> c) {
    return iterableToIterator();
  }
}
