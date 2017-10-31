package kim.andronicus.cryptoasus.conversion;

import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by andronicus on 10/31/2017.
 */

public class ConversionPresenter implements ConversionContract.Presenter{

    private ConversionContract.View mView;

    @Inject
    public ConversionPresenter(@NonNull ConversionContract.View view) {
        mView = view;
    }

    @Inject
    void setUpListeners(){
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
