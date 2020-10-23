package fetch;

import mapper.ListMapper;
import mapper.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public class Get<T> extends Request<T> {

    public static <U> Request<U> from(String destination, Class<U> clazz) {
        RestTemplate api = new RestTemplate();
        ObjectMapper<U> mapper = new ObjectMapper<>(clazz);

        ResponseEntity<String> response = api.getForEntity(destination + "/1", String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            U entity = mapper.fromJson(response.getBody());
            return new Success<>(entity);
        } else return new Failure<>(response.getStatusCode());
    }

    public static <U> Request<List<U>> from(
            String destination, ListMapper<U> mapper, Class<U> clazz) {
        RestTemplate api = new RestTemplate();
        ResponseEntity<String> response = api.getForEntity(destination + "/1", String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            List<U> list = mapper.fromJson(response.getBody());
            return new Success<>(list);
        } else return new Failure<>(response.getStatusCode());
    }

    public static <U> Request<U> from(String destination, ObjectMapper<U> mapper, Class<U> clazz) {
        RestTemplate api = new RestTemplate();
        ResponseEntity<String> response = api.getForEntity(destination + "/1", String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            U entity = mapper.fromJson(response.getBody());
            return new Success<>(entity);
        } else return new Failure<>(response.getStatusCode());
    }
}
