package org.coconut;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.coconut.Eagerly.*;
import static org.coconut.Predicates.*;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EagerlyAnyAllNoneTest {
  @SafeVarargs
  private static <T> List<T> of(T... t) {
    return Stream.of(t).collect(toList());
  }
  
  private List<Integer> numbers = of(5, 10, 15, 20);
  
  @Test
  public void shouldReturnTrueIfAnyElementsSatisfyThePredicateFunction() {
    assertThat(anyof(numbers, num -> num > 15), is(true));
  }

  @Test
  public void shouldReturnFalseIfNoElementsSatisfyThePredicateFunction() {
    assertThat(anyof(numbers, num -> num > 25), is(false));
  }

  @Test
  public void shouldReturnFalseForAnyIfTheSuppliedIterableIsEmpty() throws Exception {
    assertThat(anyof(emptyList(), (String s) -> s.length() > 5), is(false));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowNullPointerExceptionIfPredicateSuppliedToAnyIsNull() throws Exception {
    anyof(of("a", "b", "c"), null);
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowANullPointerExceptionIfIterablePassedToAnyIsNull() throws Exception {
    anyof(null, always(true));
  }

  List<String> animals = of("dog", "cat", "fish", "budgie");
  
  @Test
  public void shouldReturnTrueIfAllElementsSatisfyThePredicateFunction() {
    assertThat(allof(animals, str -> str.length() > 2), is(true));
  }

  @Test
  public void shouldReturnTrueIfAnyOfTheElementsDoNotSatisfyThePredicateFunction() {
    assertThat(allof(animals, str -> str.length() > 3), is(false));
  }

  @Test
  public void shouldReturnTrueForAllIfTheSuppliedIterableIsEmpty() {
    assertThat(allof(emptyList(), (String s) -> s.length() > 3), is(true));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowNullPointerExceptionIfPredicateSuppliedToAllIsNull() throws Exception {
    allof(of("a", "b", "c"), null);
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowANullPointerExceptionIfIterablePassedToAllIsNull() throws Exception {
    allof(null, always(true));
  }

  @Test
  public void shouldReturnTrueIfNoneOfTheElementsMatchesThePredicateFunction() {
    assertThat(noneof(of(1, 3, 5, 7), n -> n % 2 == 0), is(true));
  }

  @Test
  public void shouldReturnFalseIfAnyOfTheElementsMatchesTePredicateFunction() {
    assertThat(noneof(of(1, 3, 6, 7), n -> n % 2 == 0), is(false));
  }

  @Test
  public void shouldReturnTrueForNoneIfTheSuppliedIterableIsEmpty() throws Exception {
    assertThat(noneof(emptyList(), (String s) -> s.length() < 5), is(true));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowNullPointerExceptionIfPredicateSuppliedToNoneIsNull() throws Exception {
    noneof(of("a", "b", "c"), null);
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowANullPointerExceptionIfIterablePassedToNoneIsNull() throws Exception {
    noneof(null, alwaysTrue(String.class));
  }
}
