package org.coconut.functor.predicate;

public interface QuaternaryPredicate<A, B, C, D> {
    boolean test(A a, B b, C c, D d);
}
