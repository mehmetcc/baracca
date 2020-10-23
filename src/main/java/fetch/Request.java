package fetch;

import monad.Monad;

import java.util.function.Function;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public abstract class Request<T> implements Monad<T> {

    // Methods
    @Override /* TODO */
    public Monad flatMap(Function function) {
        return null;
    }
}
