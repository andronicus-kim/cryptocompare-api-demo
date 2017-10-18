package kim.andronicus.cryptoasus.cards;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.source.CryptodataDataSource;
import kim.andronicus.cryptoasus.data.source.CryptodataRepository;

/**
 * Created by andronicus on 10/11/2017.
 */

public class CardsPresenter implements CardsContract.Presenter{

    private CardsContract.View mView;

    private CryptodataRepository mRepository;

    @Inject
    public CardsPresenter(@NonNull CardsContract.View view,
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
    public void createCard(String code) {

        //Get BTC Exchange rate
        mRepository.getBTC(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        },code);

        //Get ETH Exchange rate
        mRepository.getETH(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        },code);
    }
}
