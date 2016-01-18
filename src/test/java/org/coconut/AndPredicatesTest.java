package org.coconut;

import static org.coconut.Predicates.always;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AndPredicatesTest {
  @Test
  public void shouldReturnTrueIfAllSuppliedPredicatesReturnTrue() throws Exception {
    assertThat(always(true).and(always(true)).test(new Object()), is(true));
  }

  @Test
  public void shouldReturnFalseIfAnySuppliedPredicatesReturnFalse() throws Exception {
    assertThat(always(true).and(always(false)).test(new Object()), is(false));
  }
}
