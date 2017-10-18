package kim.andronicus.cryptoasus.data;

/**
 * Created by andronicus on 10/13/2017.
 */

public interface DataSource<T,E,T1> {

    void getAll(T1 callback);

    void getOne(E id);

    void save(T item);

    void update(T item);

    void delete(E id);

    void deleteAll();
}
