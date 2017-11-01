package kim.andronicus.cryptoasus.cards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.appconfig.MainApplication;
import kim.andronicus.cryptoasus.util.ActivityUtils;

public class CardsActivity extends AppCompatActivity {

    @Inject
    CardsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_activity);

        CardsFragment fragment = (CardsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = CardsFragment.newInstance();
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
