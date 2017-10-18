package kim.andronicus.cryptoasus.cards;

import dagger.Component;
import kim.andronicus.cryptoasus.appconfig.ApplicationComponent;
import kim.andronicus.cryptoasus.util.FragmentScope;

/**
 * Created by andronicus on 10/18/2017.
 */
@FragmentScope
@Component(modules = CardsModule.class,dependencies = ApplicationComponent.class)
public interface CardsComponent {
    void inject(CardsActivity cardsActivity);
}
