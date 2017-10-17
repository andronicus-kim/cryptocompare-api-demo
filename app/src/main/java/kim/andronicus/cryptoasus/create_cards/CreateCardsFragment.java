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
                            case R.id.Australia:
                                break;
                        }
                        return true;
                    }
                });

            }
        });
        return view;
    }
    private void createCard(String nomination){
        startActivity(CardsActivity.newIntent(getActivity()));
    }

}
