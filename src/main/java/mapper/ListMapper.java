package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public class ListMapper<T> {

    // Variables
    private final Mapper<T> mapper;
    private final Class<T> clazz;

    // Constructors
    public ListMapper(Class<T> clazz) {
        this.clazz = clazz;
        this.mapper = new Mapper<T>(clazz);
    }

    // Methods
    public String toJson(List<T> obj) {
        String var = "";

        try {
            var = mapper.write(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return var;
    }

    public ArrayList<T> fromJson(String json) {
        ArrayList<T> obj = new ArrayList<>();
        try {
            obj = (ArrayList<T>) mapper.readList(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public Class getReflection() { return clazz; }

}
