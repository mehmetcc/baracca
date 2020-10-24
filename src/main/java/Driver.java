import fetch.Get;
import fetch.Success;
import mapper.ObjectMapper;
import monad.Monad;
import pojo.Todo;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
public class Driver {

    public static void main(String[] args) throws Exception {

        ObjectMapper<Todo> mapper = new ObjectMapper<>(Todo.class);

         Monad<Todo> todo = Get.from("https://jsonplaceholder.typicode.com/todos/1", mapper);

    }
}
