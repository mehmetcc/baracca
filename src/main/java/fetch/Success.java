package fetch;

import monad.Functor;
import monad.Monad;
import monad.Result;
import org.springframework.http.HttpStatus;

import java.util.Objects;
import java.util.function.Function;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public class Success<T> implements Result<T>, Monad<T> {

    // Variables
    private final T value;
    private final HttpStatus code;

    // Constructors
    Success(T value) {
        this.value = value;
        this.code = HttpStatus.OK;
    }

    // Methods
    @Override
    public <U> Success<U> flatMap(Function<? super T, Monad<U>> function) {
        Objects.requireNonNull(function);

        return (Success<U>) function.apply(value);
    }

    @Override
    public Boolean isPresent() {
        return true;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public T orElse(T value) {
        return value;
    }

    @Override
    public HttpStatus getHttpStatusCode() {
        return code;
    }

}
