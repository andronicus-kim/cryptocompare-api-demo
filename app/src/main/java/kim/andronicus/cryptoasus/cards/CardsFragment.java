package kim.andronicus.cryptoasus.cards;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.data.models.Card;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardsFragment extends Fragment implements CardsContract.View,CardsPresenter.callbackListener {
    private static final String TAG = "CardsFragment";

    private CardsContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private CardsAdapter mAdapter;

    private ProgressDialog mProgressDialog;

    /*
    * This method is used to instantiate the CardsFragment
    * */

    public static CardsFragment newInstance() {

        Bundle args = new Bundle();

        CardsFragment fragment = new CardsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cards_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_cards);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setCancelable(true);
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_create_cards);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),fab);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.Japan:
                                createCard("JPY");
                                break;
                            case R.id.China:
                                createCard("CNY");
                                break;
                            case R.id.Nigeria:
                                createCard("NGN");
                                break;
                            case R.id.India:
                                createCard("INR");
                                break;
                            case R.id.Singapore:
                                createCard("SGD");
                                break;
                            case R.id.Taiwan:
                                createCard("TWD");
                                break;
                            case R.id.US:
                                createCard("USD");
                                break;
                            case R.id.Australia:
                                createCard("AUD");
                                break;
                            case R.id.Europe:
                                createCard("EUR");
                                break;
                            case R.id.Great_Britain:
                                createCard("GBP");
                                break;
                            case R.id.Russia:
                                createCard("RUB");
                                break;
                            case R.id.South_Africa:
                                createCard("ZAR");
                                break;
                            case R.id.Mexico:
                                createCard("MXN");
                                break;
                            case R.id.Israel:
                                createCard("ILS");
                                break;
                            case R.id.Malaysia:
                                createCard("MYR");
                                break;
                            case R.id.New_Zealand:
                                createCard("NZD");
                                break;
                            case R.id.Sweden:
                                createCard("SEK");
                                break;
                            case R.id.Switzerland:
                                createCard("CHF");
                                break;
                            case R.id.Norway:
                                createCard("NOK");
                                break;
                            case R.id.Brazil:
                                createCard("BRL");
                                break;
                            case R.id.Turkey:
                                createCard("TRY");
                                break;
                        }
                        return true;
                    }
                });

            }
        });
        return view;
    }

    private void createCard(String code) {
        mPresenter.createCard(code);
        mProgressDialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Handler handler = new Handler(Looper.getMainLooper());
        mPresenter.initializeCallbackListener(this,handler);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(CardsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCardCreatedMessage() {
//        Toast.makeText(getActivity(), "Card Successfully Created!", Toast.LENGTH_SHORT).show();
        Snackbar.make(getView(),"Card Successfully Created!",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showCard(String exchangeRateBTC,String exchangeRateETH, String code) {
        mProgressDialog.dismiss();
        List<Card> cards = new ArrayList<>();
        Card card = new Card();
        card.setExchangeRateBTC(exchangeRateBTC);
        card.setExchangeRateETH(exchangeRateETH);
        card.setCurrency(code);
        cards.add(card);
        if (isAdded()){
            if (mAdapter == null){
                mAdapter = new CardsAdapter(cards);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
        showCardCreatedMessage();
    }

    @Override
    public void showLoadingError() {
        Toast.makeText(getActivity(), "An Error occurred!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallbacksComplete(String exchangeRateBTC, String exchangeRateETH, String code) {
        showCard(exchangeRateBTC,exchangeRateETH,code);
    }

    private class CardsAdapter extends RecyclerView.Adapter<CardsViewHolder>{

        private List<Card> mCards;

        private CardsAdapter(List<Card> cards){
            mCards = cards;
        }

       @Override
       public CardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_list_item,parent,false);
           return new CardsViewHolder(view);
       }

       @Override
       public void onBindViewHolder(CardsViewHolder holder, int position) {
            holder.bind(mCards.get(position));
       }

       @Override
       public int getItemCount() {
           return mCards.size();
       }
   }
    private class CardsViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewBTCExchangeRate;
        private TextView mTextViewETHExchangeRate;
        private TextView mTextViewBTCCurrency;
        private TextView mTextViewETHCurrency;

        public CardsViewHolder(View view) {
            super(view);
            mTextViewBTCExchangeRate = (TextView) view.findViewById(R.id.tv_btc_exchange_rate);
            mTextViewETHExchangeRate = (TextView) view.findViewById(R.id.tv_eth_exchange_rate);
            mTextViewBTCCurrency = (TextView) view.findViewById(R.id.tv_btc_currency);
            mTextViewETHCurrency = (TextView) view.findViewById(R.id.tv_eth_currency);
        }

        private void bind(Card card){
            mTextViewBTCExchangeRate.setText(card.getExchangeRateBTC());
            mTextViewBTCCurrency.setText(card.getCurrency());
            mTextViewETHExchangeRate.setText(card.getExchangeRateETH());
            mTextViewETHCurrency.setText(card.getCurrency());
        }
    }
}
