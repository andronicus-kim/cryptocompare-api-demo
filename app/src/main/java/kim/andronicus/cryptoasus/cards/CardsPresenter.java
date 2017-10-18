package kim.andronicus.cryptoasus.cards;

import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by andronicus on 10/11/2017.
 */

public class CardsPresenter implements CardsContract.Presenter{

    private CardsContract.View mView;

    @Inject
    public CardsPresenter(@NonNull CardsContract.View view) {
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

    @Override
    public void createCard(String code) {



    }
}
