package fetch;

import monad.Result;
import org.springframework.http.HttpStatus;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public class Success<T> extends Request<T> implements Result<T> {

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

    public HttpStatus getHttpStatus() {
        return code;
    }
}
