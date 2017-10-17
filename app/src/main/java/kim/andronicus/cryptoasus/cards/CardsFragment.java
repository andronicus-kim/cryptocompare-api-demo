package kim.andronicus.cryptoasus.cards;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kim.andronicus.cryptoasus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardsFragment extends Fragment {

    private static final String CURRENCY_CODE = "CURRENCY_CODE";

    private static final String TAG = "CardsFragment";

    private String mCurrencyCode;

    /*
    * This method is used to instantiate the CardsFragment
    * */

    public static CardsFragment newInstance(String code) {

        Bundle args = new Bundle();
        args.putString(CURRENCY_CODE,code);

        CardsFragment fragment = new CardsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mCurrencyCode = getArguments().getString(CURRENCY_CODE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cards_fragment, container, false);
        return view;
    }

}
