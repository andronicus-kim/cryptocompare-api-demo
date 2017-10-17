package kim.andronicus.cryptoasus.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import kim.andronicus.cryptoasus.R;
import kim.andronicus.cryptoasus.util.ActivityUtils;

public class CardsActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, CardsActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_activity);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = CardsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    R.id.fragment_container,fragment);
        }
    }
}
