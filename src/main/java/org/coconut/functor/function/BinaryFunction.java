package org.coconut.functor.function;

public interface BinaryFunction<A, B, R> {
  R apply(A a, B b);
}
