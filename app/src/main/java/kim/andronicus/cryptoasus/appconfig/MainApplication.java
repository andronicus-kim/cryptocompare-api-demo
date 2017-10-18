package kim.andronicus.cryptoasus.appconfig;

import android.app.Application;

/**
 * Created by andronicus on 10/17/2017.
 */

public class MainApplication extends Application {

    private ApplicationComponent mComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public ApplicationComponent getComponent(){
        return mComponent;
    }
}
