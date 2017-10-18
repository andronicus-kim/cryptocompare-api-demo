package kim.andronicus.cryptoasus.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.appconfig.MainApplication;
import kim.andronicus.cryptoasus.util.ActivityUtils;

public class CardsActivity extends AppCompatActivity {
    private static final String CURRENCY_CODE = "CURRENCY_CODE";

    public static Intent newIntent(Context context,String code){
        Intent intent = new Intent(context, CardsActivity.class);
        intent.putExtra(CURRENCY_CODE,code);
        return intent;
    }
    @Inject
    CardsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_activity);

        CardsFragment fragment = (CardsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = CardsFragment.newInstance(getIntent().getStringExtra(CURRENCY_CODE));
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    R.id.fragment_container,fragment);
        }
        DaggerCardsComponent.builder()
                .applicationComponent(((MainApplication)getApplication()).getComponent())
                .cardsModule(new CardsModule(fragment))
                .build()
                .inject(this);
    }
}
