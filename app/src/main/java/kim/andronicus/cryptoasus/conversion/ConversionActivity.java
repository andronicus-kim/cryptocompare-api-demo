package kim.andronicus.cryptoasus.conversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.appconfig.MainApplication;
import kim.andronicus.cryptoasus.util.ActivityUtils;

public class ConversionActivity extends AppCompatActivity {

    private static final String CONVERSION_CURRENCY = "CONVERSION_CURRENCY";

    public static Intent newIntent(Context context,String currency){
        Intent intent = new Intent(context,ConversionActivity.class);
        intent.putExtra(CONVERSION_CURRENCY,currency);
        return intent;
    }

    @Inject
    ConversionPresenter mConversionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_activity);

        ConversionFragment fragment = (ConversionFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = ConversionFragment.newInstance(getIntent().getStringExtra(CONVERSION_CURRENCY));
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.fragment_container,fragment);
        }

        DaggerConversionComponent.builder()
                .applicationComponent(((MainApplication)getApplication()).getComponent())
                .conversionModule(new ConversionModule(fragment))
                .build()
                .inject(this);
    }
}
