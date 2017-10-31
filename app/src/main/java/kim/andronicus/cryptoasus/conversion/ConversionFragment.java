package kim.andronicus.cryptoasus.conversion;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import kim.andronicus.cryptoasus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversionFragment extends Fragment implements ConversionContract.View,View.OnClickListener
{

    private static final String CONVERSION_CURRENCY = "CONVERSION_CURRENCY";

    private ConversionContract.Presenter mPresenter;

    private Button mButtonConvert;

    private EditText mEditTextCurrencyAmount;

    private String mCurrency;
    private Spinner mSpinner;

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
        mButtonConvert = (Button) view.findViewById(R.id.btn_convert_currency);
        mButtonConvert.setOnClickListener(this);
        mEditTextCurrencyAmount = (EditText) view.findViewById(R.id.et_currency_to_be_converted);
        TextView textViewCurrency = (TextView) view.findViewById(R.id.tv_conversion_currency);
        textViewCurrency.setText(mCurrency);
        mSpinner = (Spinner) view.findViewById(R.id.sp_conversion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.cryptocurrencies,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        return view;
    }

    @Override
    public void setPresenter(ConversionContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {

        if (mEditTextCurrencyAmount.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "You've not Entered Amount", Toast.LENGTH_SHORT).show();
        }
        if (mSpinner.getSelectedItem().equals("Select Currency")){
            Toast.makeText(getActivity(), "Select Currency to convert to", Toast.LENGTH_SHORT).show();
        }else if (!mEditTextCurrencyAmount.getText().toString().isEmpty() && !mSpinner.getSelectedItem().equals("Select Currency")){
            if (mSpinner.getSelectedItem().equals("BTC")){
                mPresenter.convertCurrency(mEditTextCurrencyAmount.getText().toString().trim(),"BTC");
            }
            if (mSpinner.getSelectedItem().equals("ETH")){
                mPresenter.convertCurrency(mEditTextCurrencyAmount.getText().toString().trim(),"ETH");
            }
        }

    }
}
