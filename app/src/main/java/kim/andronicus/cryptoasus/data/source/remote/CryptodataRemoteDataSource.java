package kim.andronicus.cryptoasus.data.source.remote;

import android.util.Log;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.models.Card;
import kim.andronicus.cryptoasus.data.models.CryptodataResponse;
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
    public void getBTC(final loadCardsCallback callback,String code) {
        /*
        * This client makes an api call to query BTC exchange rate against the currency given
        * */
        Call<CryptodataResponse> callBTC = mRetrofit.create(CryptodataAPIService.class).getBTCExchangeRate("BTC",code);
        callBTC.enqueue(new Callback<CryptodataResponse>() {
            @Override
            public void onResponse(Call<CryptodataResponse> call, Response<CryptodataResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getCNY());
                callback.onCryptodataLoaded(response.body().getCNY().toString());
            }

            @Override
            public void onFailure(Call<CryptodataResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getETH(final loadCardsCallback callback, String code) {
         /*
        * This client makes an api call to query ETH exchange rate against the currency given
        * */

        Call<CryptodataResponse> callETH = mRetrofit.create(CryptodataAPIService.class).getETHExchangeRate("ETH",code);
        callETH.enqueue(new Callback<CryptodataResponse>() {
            @Override
            public void onResponse(Call<CryptodataResponse> call, Response<CryptodataResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getCNY());
                if(response.body().getCNY()!=null){
                    callback.onCryptodataLoaded(response.body().getCNY().toString());
                }
                callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<CryptodataResponse> call, Throwable t) {

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
