package org.coconut.iterator;

import java.util.Iterator;
import static java.util.Objects.requireNonNull;

import org.coconut.functor.procedure.UnaryProcedure;

public class EachIterator<T> implements Iterator<T> {
  private Iterator<T> iterator;
  private UnaryProcedure<? super T> procedure;

  public EachIterator(Iterator<T> iterator, UnaryProcedure<? super T> procedure) {
    this.iterator = requireNonNull(iterator);
    this.procedure = requireNonNull(procedure);
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
