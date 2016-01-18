package org.coconut.functor.function;

public interface SenaryFunction<A, B, C, D, E, F, R> {
  R call(A a, B b, C c, D d, E e, F f);
}
