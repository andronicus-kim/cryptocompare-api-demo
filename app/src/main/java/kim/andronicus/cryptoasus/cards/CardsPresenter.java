package kim.andronicus.cryptoasus.cards;

import android.os.Handler;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.source.CryptodataDataSource;
import kim.andronicus.cryptoasus.data.source.CryptodataRepository;

/**
 * Created by andronicus on 10/11/2017.
 */

public class CardsPresenter implements CardsContract.Presenter{

    private String exchangeRateBTC;

    private String exchangeRateETH;

    private callbackListener mCallbackListener;

    private Handler mHandler;

    private CardsContract.View mView;

    private CryptodataRepository mRepository;
    private Thread mBackgroungThread;

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
        mBackgroungThread.interrupt();

    }

    @Override
    public void createCard(final String code) {


        //Get BTC Exchange rate
        mRepository.getBTC(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {
                exchangeRateBTC = message;
            }

            @Override
            public void onDataNotAvailable() {
                mView.showLoadingError();
            }
        },code);

        //Get ETH Exchange rate
        mRepository.getETH(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {
                exchangeRateETH = message;
            }

            @Override
            public void onDataNotAvailable() {

                mView.showLoadingError();
            }
        },code);

        /*
        * Background Thread that waits for both network calls to finish then
        * update the UI
        *
        * */

        mBackgroungThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if (exchangeRateETH!=null && exchangeRateBTC!=null){
                        if (!exchangeRateBTC.isEmpty() && !exchangeRateETH.isEmpty()){
                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                /*
                                * Update UI using MainThread's Handler
                                * */
                                    mHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            mCallbackListener.onCallbacksComplete(exchangeRateBTC,exchangeRateETH,code);
                                            exchangeRateBTC = null;
                                            exchangeRateETH = null;
                                        }
                                    });
                                }
                            };
                            runnable.run();
                            break;
                        }
                    }

                }
            }
        });
        mBackgroungThread.start();
    }
    /*
    * Interface to post back results
    * */
    interface callbackListener{
        void onCallbacksComplete(String exchangeRateBTC,String exchangeRateETH,String code);
    }
    public void initializeCallbackListener(callbackListener listener, Handler handler){
        mCallbackListener = listener;
        mHandler = handler;
    }
}
