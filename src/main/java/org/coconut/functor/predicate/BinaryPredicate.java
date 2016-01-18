package org.coconut.functor.predicate;

public interface BinaryPredicate<A, B> {
    boolean test(A a, B b);
}
