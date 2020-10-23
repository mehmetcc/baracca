package monad;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */

import java.util.function.Function;

/**
 * Monad.java An abstract Monad interface in which holds a value based on the type provided.
 *
 * <p>According to Martin Odersky, a Monad should satisfy these three rules: 1) The type must be
 * parameterized 2) The type should have a Unit function, ie. a static method that returns a new
 * Monad object based on the information provided 3) The type should have the ability to be binded,
 * usually done with flatMap methods in the JVM ecosystem.
 *
 * <p>The unit function is left to the implementations of the class, as it varies greatly between
 * different types
 *
 * @param <T> Type of the Value to be encapsulated
 */
@FunctionalInterface
public interface Monad<T> {

    <U> Monad<U> flatMap(Function<? super T, Monad<U>> function);
}
