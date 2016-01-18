package org.coconut;

import org.coconut.functor.Mapper;
import org.coconut.functor.predicate.UnaryPredicate;

import static java.util.Objects.*;

public final class Objects {
  private Objects() {
  }
  
  public static <T> UnaryPredicate<T> whereNull() {
    return obj -> isNull(obj);
  }

  public static <T> UnaryPredicate<T> whereNull(Class<?> c) {
    return whereNull();
  }

  public static <T> UnaryPredicate<T> whereNotNull() {
    return obj -> nonNull(obj);
  }
  
  public static <T> UnaryPredicate<T> whereNotNull(Class<?> c) {
    return whereNotNull();
  }

  public static <T> Mapper<T, String> toStr() {
    return t -> String.valueOf(t);
  }

  public static <T> Mapper<T, String> toStr(Class<T> target) {
    return t -> String.valueOf(t);
  }
}
