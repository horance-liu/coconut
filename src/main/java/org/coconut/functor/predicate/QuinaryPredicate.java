package org.coconut.functor.predicate;

public interface QuinaryPredicate<A, B, C, D, E> {
    boolean test(A a, B b, C c, D d, E e);
}
