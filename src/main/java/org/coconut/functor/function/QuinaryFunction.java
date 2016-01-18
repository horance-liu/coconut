package org.coconut.functor.function;

public interface QuinaryFunction<A, B, C, D, E, R> {
  R apply(A a, B b, C c, D d, E e);
}
