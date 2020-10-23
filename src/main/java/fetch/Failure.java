package fetch;

import monad.Result;
import org.springframework.http.HttpStatus;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public class Failure<T> extends Request<T> implements Result<T> {

    // Variables
    private final HttpStatus code;

    // Constructors
    Failure(HttpStatus code) {
        this.code = code;
    }

    // Methods
    @Override
    public Boolean isPresent() {
        return false;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public T orElse(T value) {
        return null;
    }
}
