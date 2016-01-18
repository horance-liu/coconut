package org.coconut.functor;

import org.coconut.functor.function.UnaryFunction;

@FunctionalInterface
public interface Mapper<I, T> extends UnaryFunction<I, T> {
  default T map(I input) {
    return apply(input);
  }
}
