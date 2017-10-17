package kim.andronicus.cryptoasus.appconfig;

import android.content.Context;

import dagger.Component;

/**
 * Created by andronicus on 10/17/2017.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context context();
}
