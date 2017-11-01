package kim.andronicus.cryptoasus.cards;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.source.CryptodataDataSource;
import kim.andronicus.cryptoasus.data.source.CryptodataRepository;

/**
 * Created by andronicus on 10/11/2017.
 */

public class CardsPresenter implements CardsContract.Presenter{

    private String exchangeRateBTC;

    private String exchangeRateETH;

    private boolean updating = false;

    private boolean BTCReceived = false;

    private boolean ETHReceived = false;

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
        //Interrupt Thread if fragment is destroyed
        if (mBackgroungThread!=null){
            mBackgroungThread.interrupt();
        }
    }

    @Override
    public void createCard(final String code) {

        updating = true;


        //Get BTC Exchange rate
        mRepository.getBTC(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {
                BTCReceived = true;
                exchangeRateBTC = message;

            }

            @Override
            public void onDataNotAvailable() {
                mView.showLoadingError();
            }

            @Override
            public void resetValues(boolean state) {
                resetBTC(state);
            }
        },code);

        //Get ETH Exchange rate
        mRepository.getETH(new CryptodataDataSource.loadCardsCallback() {
            @Override
            public void onCryptodataLoaded(String message) {
                ETHReceived = true;
                exchangeRateETH = message;

            }

            @Override
            public void onDataNotAvailable() {

                mView.showLoadingError();
            }

            @Override
            public void resetValues(boolean state) {

                resetETH(state);

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
                /*
                * A loop that runs while updating is true until both
                * network calls return values for Bitcoin and Ethereum
                * */
                while(updating){
                    if (BTCReceived && ETHReceived){
                        updating = false;
                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                /*
                                * Update UI using MainThread's Handler
                                * */
                                    mHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            mView.dismissDialog();
                                            mCallbackListener.onCallbacksComplete(exchangeRateBTC,exchangeRateETH,code);
                                        }
                                    });
                                }
                            };
                            runnable.run();
                    }

                }
            }
        });
        mBackgroungThread.start();
    }

    @Override
    public void resetBTC(boolean state) {
        BTCReceived = state;

    }@Override
    public void resetETH(boolean state) {
        ETHReceived = state;
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
