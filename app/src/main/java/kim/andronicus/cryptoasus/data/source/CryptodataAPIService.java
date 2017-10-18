package kim.andronicus.cryptoasus.data.source;

import kim.andronicus.cryptoasus.data.models.CryptodataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by andronicus on 10/18/2017.
 */

public interface CryptodataAPIService {

    @GET("price")
    Call<CryptodataResponse> getBTCExchangeRate(@Query("fsym") String fCode,
                                                @Query("tsyms") String tCode);
    @GET("price")
    Call<CryptodataResponse> getETHExchangeRate(@Query("fsym") String fCode,
                                                @Query("tsyms") String tCode);
}
