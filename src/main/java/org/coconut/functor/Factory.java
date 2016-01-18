package org.coconut.functor;

import org.coconut.functor.function.NullaryFunction;

@FunctionalInterface
public interface Factory<T> extends NullaryFunction<T> {
  default T create() {
    return apply();
  }
}
