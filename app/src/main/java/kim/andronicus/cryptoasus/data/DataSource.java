package kim.andronicus.cryptoasus.data;

/**
 * Created by andronicus on 10/13/2017.
 */

public interface DataSource<T,E,T1> {

    void getAll(T1 callback);

    void getBTC(T1 callback,String code);

    void getETH(T1 callback, String code);

    void getConvertedCurrency(T1 callback,String fCode,String tCode);

}
