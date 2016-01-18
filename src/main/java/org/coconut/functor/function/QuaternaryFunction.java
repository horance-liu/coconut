package org.coconut.functor.function;

public interface QuaternaryFunction<A, B, C, D, R> {
  R apply(A a, B b, C c, D d);
}
