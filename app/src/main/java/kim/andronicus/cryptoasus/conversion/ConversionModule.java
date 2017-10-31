package kim.andronicus.cryptoasus.conversion;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andronicus on 10/31/2017.
 */
@Module
public class ConversionModule {

    private final ConversionContract.View mView;

    public ConversionModule(ConversionContract.View view){
        mView = view;
    }

    @Provides
    ConversionContract.View provideView(){
        return mView;
    }
}
