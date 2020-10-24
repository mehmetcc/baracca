package monad;

import java.util.function.Function;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
@FunctionalInterface
public interface Functor {

    /* TODO */
    public abstract <U> U map();
}
