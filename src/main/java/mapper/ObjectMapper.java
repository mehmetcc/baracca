package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */
public class ObjectMapper<T> {

    // Variables
    private final Mapper<T> mapper;
    private final Class<T> clazz;

    // Constructors
    public ObjectMapper(Class<T> clazz) {
        this.clazz = clazz;
        this.mapper = new Mapper<T>(clazz);
    }

    // Methods
    public String toJson(T obj) {
        String var = "";

        try {
            var = mapper.write(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return var;
    }

    public T fromJson(String json) {
        T obj = null;
        try {
            obj = mapper.readObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public Class getReflection() { return clazz; }
}
