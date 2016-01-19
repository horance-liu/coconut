package org.coconut.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BatchedIterator<T> implements Iterator<Iterable<T>> {
  private Iterator<? extends T> iterator;
  private int size;

  public BatchedIterator(Iterator<? extends T> iterator, int size) {
    this.iterator = iterator;
    this.size = size;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public Iterable<T> next() {
    return Collections.unmodifiableList(nextBatch());
  }
  
  private List<T> nextBatch() {
    List<T> batch = new ArrayList<T>();
    for (int i=0; i<size && iterator.hasNext(); i++) {
      batch.add(iterator.next());
    }
    return batch;
  }
}
