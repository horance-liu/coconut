package org.coconut.functor.predicate;

public interface UnaryPredicate<A> {
  boolean test(A a);

  default UnaryPredicate<A> and(UnaryPredicate<? super A> other) {
    return a -> test(a) && other.test(a);
  }

  default UnaryPredicate<A> or(UnaryPredicate<? super A> other) {
    return a -> test(a) || other.test(a);
  }

  default UnaryPredicate<A> negate() {
    return a -> !test(a);
  }
}
