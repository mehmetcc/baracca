import com.fasterxml.jackson.core.JsonProcessingException;
import mapper.Mapper;
import pojo.DataStructure;
import pojo.User;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public class Driver {

    public static void main(String[] args) {
        User mehmet = new User("mehmet", "pass");
        User ahmet = new User("ahmet", "pass1");

        DataStructure<User> ds = new DataStructure<>(mehmet);

        ArrayList<User> users = new ArrayList<>();
        users.add(mehmet);
        users.add(ahmet);

        Mapper<DataStructure> userMapper = new Mapper<DataStructure>(DataStructure.class);

        try {
            String json = userMapper.write(ds);

            System.out.println(json);
            System.out.println(userMapper.readObject(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
