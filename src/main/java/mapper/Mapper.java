package mapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş github.com/mehmetcc
 */


public class Mapper<T> {

  // Variables
  private final ObjectMapper mapper;
  private final Class<T> clazz;

  // Constructors
  public Mapper(Class<T> clazz) {
    AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();

    mapper = new ObjectMapper();
    mapper.getDeserializationConfig().with(introspector);
    mapper.getSerializationConfig().with(introspector);

    this.clazz = clazz;
  }

  // Methods
  public String write(List<T> list) throws JsonProcessingException {
    return mapper.writeValueAsString(list);
  }

  public String write(T obj) throws JsonProcessingException {
    return mapper.writeValueAsString(obj);
  }

  public List<T> readList(String json)
      throws JsonParseException, JsonMappingException, IOException {
    return readList(json, mapper, clazz);
  }
  public List<T> readList(InputStream stream)
      throws JsonParseException, JsonMappingException, IOException {
      return readList(stream, mapper, clazz);
  }

  public T readObject(String json)
      throws JsonProcessingException, JsonMappingException, IOException {
    return mapper.readValue(json, clazz);
  }

  public T readObject(InputStream stream)
          throws JsonProcessingException, JsonMappingException, IOException{
      return mapper.readValue(stream, clazz);
  }

  private static <U> List<U> readList(String json, ObjectMapper mapper, Class<U> clazz)
      throws JsonParseException, JsonMappingException, IOException {
    return mapper.readValue(json, reflectAsList(mapper, clazz));
  }

  private static <U> List<U> readList(InputStream stream, ObjectMapper mapper, Class<U> clazz)
      throws JsonParseException, JsonMappingException, IOException {
    return mapper.readValue(stream, reflectAsList(mapper, clazz));
  }

  private static <U> JavaType reflectAsList(ObjectMapper mapper, Class<U> clazz) {
    return mapper.getTypeFactory().constructCollectionType(List.class, clazz);
  }
}
