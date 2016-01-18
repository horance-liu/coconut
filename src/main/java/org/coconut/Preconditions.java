package org.coconut;

public final class Preconditions {
  private Preconditions() {
  }
  
  public static void checkArgument(boolean exp) {
    if (!exp)
      throw new IllegalArgumentException();
  }
      
  public static void checkArgument(boolean exp, Object msg) {
    if (!exp)
      throw new IllegalArgumentException(String.valueOf(msg));
  }

  public static void checkState(boolean expression) {
    if (!expression)
      throw new IllegalStateException();
  }
  
  public static void checkState(boolean exp, Object msg) {
    if (!exp)
      throw new IllegalStateException(String.valueOf(msg));
  }
}
