package fetch;

import monad.Monad;
import monad.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

import java.util.Objects;
import java.util.function.Function;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public class Failure<T> implements Result<T>, Monad<T> {

    // Variables
    private final HttpStatus code;
    private final HttpStatusCodeException exception;

    // Constructors
    Failure(HttpStatusCodeException exception) {
        this.exception = exception;
        this.code = exception.getStatusCode();
    }

    // Methods
    @Override
    public <U> Failure<U> flatMap(Function<? super T, Monad<U>> function) {
        Objects.requireNonNull(function);
        return new Failure<>(this.exception);
    }

    @Override
    public Boolean isPresent() {
        return false;
    }

    @Override
    public T get() throws Exception {
        throw exception;
    }

    public T orElse(T value) {
        return null;
    }

    @Override
    public HttpStatus getHttpStatusCode() { return code; }

}
