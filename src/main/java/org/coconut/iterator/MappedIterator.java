package org.coconut.iterator;

import org.coconut.functor.function.UnaryFunction;

import java.util.Iterator;

public class MappedIterator<S, T> implements Iterator<T> {
  private Iterator<? extends S> iterator;
  private UnaryFunction<? super S, ? extends T> function;

  public MappedIterator(Iterator<? extends S> iterator, UnaryFunction<? super S, ? extends T> mapper) {
    this.iterator = iterator;
    this.function = mapper;
  }

  public boolean hasNext() {
    return iterator.hasNext();
  }

  public T next() {
    return function.apply(iterator.next());
  }

  public void remove() {
    iterator.remove();
  }
}
