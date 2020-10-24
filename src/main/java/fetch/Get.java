package fetch;

import mapper.ListMapper;
import mapper.ObjectMapper;
import monad.Functor;
import monad.Monad;
import monad.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public class Get<T> {

    public static <U> Monad<U> from(String destination, Class<U> clazz) {
        RestTemplate api = new RestTemplate();
        ObjectMapper<U> mapper = new ObjectMapper<>(clazz);

        try {
            ResponseEntity<String> response = api.getForEntity(destination, String.class);

            U entity = mapper.fromJson(response.getBody());
            return new Success<>(entity);
        } catch (HttpStatusCodeException exception) {
            return new Failure<>(exception);
        }
    }

    public static <U> Monad<List<U>> from(String destination, ListMapper<U> mapper) {
        RestTemplate api = new RestTemplate();

        try {
            ResponseEntity<String> response = api.getForEntity(destination, String.class);

            List<U> list = mapper.fromJson(response.getBody());
            return new Success<>(list);
        } catch (HttpStatusCodeException exception) {
            return new Failure<>(exception);
        }
    }

    public static <U> Monad<U> from(String destination, ObjectMapper<U> mapper) {
        RestTemplate api = new RestTemplate();

        try {
            ResponseEntity<String> response = api.getForEntity(destination, String.class);
            U entity = mapper.fromJson(response.getBody());
            return new Success<>(entity);
        } catch (HttpStatusCodeException exception) {
            return new Failure<>(exception);
        }
    }

    public static <U> Monad<U> from(U value) {
        return new Success<>(value);
    }

}
