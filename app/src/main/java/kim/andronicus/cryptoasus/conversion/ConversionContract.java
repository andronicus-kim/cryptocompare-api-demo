package kim.andronicus.cryptoasus.conversion;

import kim.andronicus.cryptoasus.BasePresenter;
import kim.andronicus.cryptoasus.BaseView;

/**
 * Created by andronicus on 10/31/2017.
 */

public interface ConversionContract {

    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter{

        void convertCurrency(String fCode, String tCode);

    }
}
