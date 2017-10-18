package kim.andronicus.cryptoasus.data.source;

import kim.andronicus.cryptoasus.data.DataSource;
import kim.andronicus.cryptoasus.data.models.Card;

/**
 * Created by andronicus on 10/18/2017.
 */

public interface CryptodataDataSource extends DataSource<Card,String,CryptodataDataSource.loadCardsCallback> {

    interface loadCardsCallback{

        void onCryptodataLoaded(String message);

        void onDataNotAvailable();

    }
}
