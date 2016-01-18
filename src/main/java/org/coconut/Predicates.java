package org.coconut;

import java.util.Objects;

import org.coconut.functor.Predicate;

public final class Predicates {
  public static <T> Predicate<T> always(boolean bool) {
    return t -> bool;
  }
  
  public static <T> Predicate<T> alwaysTrue(Class<?> c) {
    return always(true);
  }
    
  public static <T> Predicate<T> alwaysFalse(Class<?> c) {
    return always(false);
  }

  public static <T> Predicate<T> instanceOf(Class<?> c) {
    return t -> c.isInstance(t);
  }

  public static <T> Predicate<T> equalTo(Object obj) {
    return t -> Objects.equals(obj, t);
  }
  
  public static <T> Predicate<T> deepEqualTo(Object obj) {
    return t -> Objects.deepEquals(obj, t);
  }
  
  public static <T> Predicate<T> isNull() {
    return t -> t == null;
  }
  
  public static <T> Predicate<T> isNull(Class<?> c) {
    return t -> t == null;
  }
  
  public static <T> Predicate<T> isNotNull() {
    return t -> t != null;
  }
  
  public static <T> Predicate<T> isNotNull(Class<?> c) {
    return t -> t != null;
  }
  
  private Predicates() {
  }
}
