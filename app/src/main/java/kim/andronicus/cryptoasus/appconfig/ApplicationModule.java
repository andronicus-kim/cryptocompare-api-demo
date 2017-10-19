package kim.andronicus.cryptoasus.appconfig;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andronicus on 10/17/2017.
 */
@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext(){
        return mContext;
    }

    @Provides
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    OkHttpClient provideClient(HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120,TimeUnit.SECONDS)
                .build();
    }
    @Provides
    Retrofit provideRetrofit(OkHttpClient client){
       return new Retrofit.Builder()
               .baseUrl("https://min-api.cryptocompare.com/data/")
               .client(client)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }

}
