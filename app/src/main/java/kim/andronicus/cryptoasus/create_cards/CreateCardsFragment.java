package kim.andronicus.cryptoasus.create_cards;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.cards.CardsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateCardsFragment extends Fragment {


    public static CreateCardsFragment newInstance() {
        return new CreateCardsFragment();
    }
    public CreateCardsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.create_cards_fragment, container, false);
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
    private void createCard(String code){
        startActivity(CardsActivity.newIntent(getActivity(),code));
    }

}
