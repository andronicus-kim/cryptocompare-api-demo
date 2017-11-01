package kim.andronicus.cryptoasus.data.source.remote;

import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.models.Card;
import kim.andronicus.cryptoasus.data.source.CryptodataAPIService;
import kim.andronicus.cryptoasus.data.source.CryptodataDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andronicus on 10/13/2017.
 */

public class CryptodataRemoteDataSource implements CryptodataDataSource{

    private static final String TAG = CryptodataRemoteDataSource.class.getSimpleName();

    @Inject
    CryptodataRemoteDataSource(){}

    @Inject
    Retrofit mRetrofit;

    @Override
    public void getAll(final loadCardsCallback callback) {

    }

    @Override
    public void getBTC(final loadCardsCallback callback,final String code) {
        /*
        * This client makes an api call to query BTC exchange rate against the currency given
        * */
        Call<Map<String,Object>> callBTC = mRetrofit.create(CryptodataAPIService.class).getBTCExchangeRate("BTC",code);
        callBTC.enqueue(new Callback<Map<String,Object>>() {
            @Override
            public void onResponse(Call<Map<String,Object>> call, Response<Map<String,Object>> response) {
                if (response.body()!=null){
                    Map<String,Object> mappedResponse = response.body();
                    Log.d(TAG, "CNY BTC: " + String.valueOf((double)(mappedResponse.get(code))));
                    callback.onCryptodataLoaded(String.valueOf((double)(mappedResponse.get(code))));
                }
            }

            @Override
            public void onFailure(Call<Map<String,Object>> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getETH(final loadCardsCallback callback, final String code) {
         /*
        * This client makes an api call to query ETH exchange rate against the currency given
        * */

        Call<Map<String,Object>> callETH = mRetrofit.create(CryptodataAPIService.class).getETHExchangeRate("ETH",code);
        callETH.enqueue(new Callback<Map<String,Object>>() {
            @Override
            public void onResponse(Call<Map<String,Object>> call, Response<Map<String,Object>> response) {
                if(response.body()!=null){
                    Map<String,Object> mappedResponse = response.body();
                    Log.d(TAG, "CNY ETH: " + String.valueOf((double)(mappedResponse.get(code))));
                    callback.onCryptodataLoaded(String.valueOf((double)(mappedResponse.get(code))));
                }
            }

            @Override
            public void onFailure(Call<Map<String,Object>> call, Throwable t) {

                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getConvertedCurrency(final loadCardsCallback callback, String fCode, final String tCode) {
        Call<Map<String,Object>> call = mRetrofit.create(CryptodataAPIService.class).convertCurrency(fCode,tCode);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.body()!=null){
                    Map<String,Object> mappedResponse = response.body();
                    Log.d(TAG, "Conversion: " + String.valueOf((double)(mappedResponse.get(tCode))));
                    callback.onCryptodataLoaded(String.valueOf((double)(mappedResponse.get(tCode))));
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

                callback.onDataNotAvailable();

            }
        });
    }

    @Override
    public void getOne(String id) {

    }

    @Override
    public void save(Card item) {

    }

    @Override
    public void update(Card item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
