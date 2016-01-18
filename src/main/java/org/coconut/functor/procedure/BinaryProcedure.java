package org.coconut.functor.procedure;

public interface BinaryProcedure<A, B> {
  void exec(A a, B b);
}
