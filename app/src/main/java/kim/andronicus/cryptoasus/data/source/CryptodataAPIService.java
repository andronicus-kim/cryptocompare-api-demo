package kim.andronicus.cryptoasus.data.source;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by andronicus on 10/18/2017.
 */

public interface CryptodataAPIService {

    @GET("price")
    Call<Map<String,Object>> getBTCExchangeRate(@Query("fsym") String fCode,
                                                @Query("tsyms") String tCode);
    @GET("price")
    Call<Map<String,Object>> getETHExchangeRate(@Query("fsym") String fCode,
                                                @Query("tsyms") String tCode);
}
