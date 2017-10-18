package kim.andronicus.cryptoasus.cards;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.models.Card;
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
        mRepository.getAll(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(Card card) {
                mView.showCardCreated();
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
