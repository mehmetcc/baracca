package monad;

import org.springframework.http.HttpStatus;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public interface Result<T> {

    Boolean isPresent();

    T get() throws Exception;

    T orElse(T value);

    HttpStatus getHttpStatusCode();
}
