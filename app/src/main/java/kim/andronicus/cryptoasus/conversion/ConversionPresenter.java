package kim.andronicus.cryptoasus.conversion;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.source.CryptodataRepository;

/**
 * Created by andronicus on 10/31/2017.
 */

public class ConversionPresenter implements ConversionContract.Presenter{

    private ConversionContract.View mView;

    private CryptodataRepository mRepository;

    @Inject
    public ConversionPresenter(@NonNull ConversionContract.View view,
                               @NonNull CryptodataRepository repository) {
        mView = view;
        mRepository = repository;
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

    @Override
    public void convertCurrency(String fCode, String tCode) {

    }
}
