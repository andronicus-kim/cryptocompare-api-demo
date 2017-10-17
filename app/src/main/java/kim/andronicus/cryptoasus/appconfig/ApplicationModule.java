package kim.andronicus.cryptoasus.appconfig;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

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

}
