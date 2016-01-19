package org.coconut.iterator;

import java.util.Iterator;

import org.coconut.functor.procedure.UnaryProcedure;

public class EachIterator<T> implements Iterator<T> {
  private Iterator<? extends T> iterator;
  private UnaryProcedure<? super T> procedure;

  public EachIterator(Iterator<? extends T> iterator, UnaryProcedure<? super T> procedure) {
    this.iterator = iterator;
    this.procedure = procedure;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public T next() {
    T next = iterator.next();
    procedure.exec(next);
    return next;
  }
}
