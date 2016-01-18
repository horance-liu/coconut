package org.coconut.functor;

import org.coconut.functor.function.UnaryFunction;

@FunctionalInterface
public interface Indexer<I, R> extends UnaryFunction<I, R> {
  default R index(I input) {
    return apply(input);
  }
}
