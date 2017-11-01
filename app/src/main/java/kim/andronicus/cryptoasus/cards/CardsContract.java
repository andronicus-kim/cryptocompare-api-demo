package kim.andronicus.cryptoasus.cards;

import android.os.Handler;

import kim.andronicus.cryptoasus.BasePresenter;
import kim.andronicus.cryptoasus.BaseView;

/**
 * Created by andronicus on 10/11/2017.
 */

public interface CardsContract {

    interface View extends BaseView<Presenter>{

        void showCardCreatedMessage();

        void showCard(String exchangeRateBTC,String exchangeRateETH, String code);

        void showLoadingError();

        void dismissDialog();

//        void showETHCard(String exchangeRate, String code);

    }
    interface Presenter extends BasePresenter{
        void createCard(String code);

        void resetBTC(boolean state);

        void resetETH(boolean state);

        void initializeCallbackListener(CardsPresenter.callbackListener listener, Handler handler);
    }
}
