package org.coconut.functor;

import org.coconut.functor.predicate.BinaryPredicate;

@FunctionalInterface
public interface Equivalence<T> extends BinaryPredicate<T, T> {
  default boolean equal(T first, T second) {
    return test(first, second);
  }
}
