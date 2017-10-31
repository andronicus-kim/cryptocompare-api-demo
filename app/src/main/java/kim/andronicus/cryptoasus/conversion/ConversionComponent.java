package kim.andronicus.cryptoasus.conversion;

import dagger.Component;
import kim.andronicus.cryptoasus.appconfig.ApplicationComponent;
import kim.andronicus.cryptoasus.util.FragmentScope;

/**
 * Created by andronicus on 10/31/2017.
 */
@FragmentScope
@Component(modules = ConversionModule.class,dependencies = ApplicationComponent.class)
public interface ConversionComponent {

    void inject(ConversionActivity conversionActivity);
}
