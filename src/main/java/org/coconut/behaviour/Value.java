package org.coconut.behaviour;

@FunctionalInterface
public interface Value<T> {
  T get();
}
