package org.coconut.iterator;

import org.coconut.functor.predicate.UnaryPredicate;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PredicatedIterator<T> extends CachingIterator<T> {
  private Iterator<? extends T> iterator;
  private UnaryPredicate<? super T> predicate;

  public PredicatedIterator(Iterator<? extends T> iterator, UnaryPredicate<? super T> predicate) {
    this.iterator = iterator;
    this.predicate = predicate;
  }

  @Override
  protected T findNext() {
    if (!iterator.hasNext()) {
      T next = iterator.next();
      if (predicate.test(next)) {
        return next;
      }      
    }
    throw new NoSuchElementException();
  }

  @Override
  protected void removeLast() {
    iterator.remove();
  }
}
