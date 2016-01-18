package org.coconut.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;
import static org.coconut.Preconditions.checkArgument;

public class BatchedIterator<T> implements Iterator<Iterable<T>> {
  private Iterator<? extends T> iterator;
  private int batchSize;

  public BatchedIterator(Iterator<? extends T> iterator, int batchSize) {
    checkArgument(batchSize > 0, "Batch size must be greater than zero.");
    this.iterator = requireNonNull(iterator);
    this.batchSize = batchSize;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public Iterable<T> next() {
    return unmodifiableList(nextBatch());
  }
  
  private List<T> nextBatch() {
    List<T> batch = new ArrayList<T>();
    for (int i = 0; i < batchSize; i++)
      if (iterator.hasNext())
        batch.add(iterator.next());
    return batch;
  }
}
