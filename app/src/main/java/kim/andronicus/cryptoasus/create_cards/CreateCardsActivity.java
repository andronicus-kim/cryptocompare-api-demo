package kim.andronicus.cryptoasus.create_cards;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.util.ActivityUtils;

public class CreateCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_cards_activity);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = CreateCardsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    R.id.fragment_container,
                    fragment);
        }
    }
}
