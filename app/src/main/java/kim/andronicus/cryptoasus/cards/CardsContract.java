package kim.andronicus.cryptoasus.cards;

import kim.andronicus.cryptoasus.BasePresenter;
import kim.andronicus.cryptoasus.BaseView;

/**
 * Created by andronicus on 10/11/2017.
 */

public interface CardsContract {

    interface View extends BaseView<Presenter>{

        void showCardCreated();

    }
    interface Presenter extends BasePresenter{
        void createCard(String code);

    }
}
