package org.coconut.functor.function;

public interface TernaryFunction<A, B, C, R> {
  R apply(A a, B b, C c);
}
