package org.coconut.iterator;

import org.coconut.functor.predicate.UnaryPredicate;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.*;

public class FilteredIterator<T> extends CachingIterator<T> {
  private Iterator<? extends T> iterator;
  private UnaryPredicate<? super T> predicate;

  public FilteredIterator(Iterator<? extends T> iterator, UnaryPredicate<? super T> predicate) {
    this.iterator = requireNonNull(iterator);
    this.predicate = requireNonNull(predicate);
  }

  @Override
  protected T findNext() {
    while (iterator.hasNext()) {
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
