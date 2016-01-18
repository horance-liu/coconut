package org.coconut.behaviour;

import org.coconut.functor.function.UnaryFunction;

@FunctionalInterface
public interface Mappable<I, O extends Mappable<?, O>> {
  <T> O map(UnaryFunction<? super I, ? extends T> mapper);
}
