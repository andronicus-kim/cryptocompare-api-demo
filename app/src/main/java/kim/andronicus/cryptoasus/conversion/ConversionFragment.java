package kim.andronicus.cryptoasus.conversion;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import kim.andronicus.cryptoasus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversionFragment extends Fragment implements ConversionContract.View{

    private static final String CONVERSION_CURRENCY = "CONVERSION_CURRENCY";

    private ConversionContract.Presenter mPresenter;

    private String mCurrency;

    public static ConversionFragment newInstance(String currency) {

        Bundle args = new Bundle();
        args.putString(CONVERSION_CURRENCY,currency);

        ConversionFragment fragment = new ConversionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ConversionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrency = getArguments().getString(CONVERSION_CURRENCY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.conversion_fragment, container, false);
        TextView textViewCurrency = (TextView) view.findViewById(R.id.tv_conversion_currency);
        textViewCurrency.setText(mCurrency);
        Spinner spinner = (Spinner) view.findViewById(R.id.sp_conversion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.cryptocurrencies,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return view;
    }

    @Override
    public void setPresenter(ConversionContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
