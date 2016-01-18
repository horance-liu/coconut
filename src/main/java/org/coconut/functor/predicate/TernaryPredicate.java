package org.coconut.functor.predicate;

public interface TernaryPredicate<A, B, C> {
    boolean test(A a, B b, C c);
}
