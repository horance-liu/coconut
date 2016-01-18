package org.coconut.functor;

import org.coconut.functor.function.BinaryFunction;

@FunctionalInterface
public interface Reducer<S, T> extends BinaryFunction<T, S, T> {
  default T accumulate(T accumulator, S element) {
    return apply(accumulator, element);
  }
}
