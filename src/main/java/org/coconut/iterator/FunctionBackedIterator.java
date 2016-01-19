package org.coconut.iterator;

import org.coconut.functor.function.NullaryFunction;

import java.util.Iterator;

public class FunctionBackedIterator<T> implements Iterator<T> {
  private NullaryFunction<? extends T> function;

  public FunctionBackedIterator(NullaryFunction<? extends T> function) {
    this.function = function;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public T next() {
    return function.apply();
  }
}
