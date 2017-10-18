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
    public void getAll(loadCardsCallback callback) {

        Call<CryptodataResponse> call = mRetrofit.create(CryptodataAPIService.class).getExchangeRate("BTC","USD");
        call.enqueue(new Callback<CryptodataResponse>() {
            @Override
            public void onResponse(Call<CryptodataResponse> call, Response<CryptodataResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getUSD());
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
