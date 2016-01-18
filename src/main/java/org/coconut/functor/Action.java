package org.coconut.functor;

import org.coconut.functor.procedure.UnaryProcedure;

@FunctionalInterface
public interface Action<T> extends UnaryProcedure<T> {
  default void on(T input) {
    exec(input);
  }
}
