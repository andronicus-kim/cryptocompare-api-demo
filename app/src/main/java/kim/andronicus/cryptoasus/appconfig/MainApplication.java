package kim.andronicus.cryptoasus.appconfig;

import android.app.Application;

/**
 * Created by andronicus on 10/17/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
