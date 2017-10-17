package kim.andronicus.cryptoasus.cards;

import android.support.annotation.NonNull;

import kim.andronicus.cryptoasus.data.source.CryptodataRepository;

/**
 * Created by andronicus on 10/11/2017.
 */

public class CardsPresenter implements CardsContract.Presenter{

    private CryptodataRepository mRepository;
    private CardsContract.View mView;

    public CardsPresenter(@NonNull CryptodataRepository repository,
                          @NonNull CardsContract.View view) {
        mRepository = repository;
        mView = view;

        //Set Presenter
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


    }
}
