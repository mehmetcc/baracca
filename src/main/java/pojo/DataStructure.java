package pojo;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */

/**
 * For testing purposes only
 * Delete in production
 */
public class DataStructure<T> {

    private T data;

    public DataStructure(T t) {
        this.data = t;
    }

    public DataStructure() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "success!!!!";
    }
}
