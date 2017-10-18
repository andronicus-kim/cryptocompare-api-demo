package kim.andronicus.cryptoasus.appconfig;

import android.content.Context;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by andronicus on 10/17/2017.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context exposeContext();
    Retrofit exposeRetrofit();
}
