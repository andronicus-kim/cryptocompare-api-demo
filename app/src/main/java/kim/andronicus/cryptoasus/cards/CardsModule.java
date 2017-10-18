package kim.andronicus.cryptoasus.cards;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andronicus on 10/18/2017.
 */
@Module
public class CardsModule {

    private final CardsContract.View mView;

    public CardsModule(CardsContract.View view) {
        mView = view;
    }

    @Provides
    @NonNull
    CardsContract.View provideView(){
        return mView;
    }
}
