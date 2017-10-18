package kim.andronicus.cryptoasus.data.source;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import kim.andronicus.cryptoasus.data.models.Card;
import kim.andronicus.cryptoasus.data.source.remote.CryptodataRemoteDataSource;

/**
 * Created by andronicus on 10/13/2017.
 */

public class CryptodataRepository implements CryptodataDataSource{

    private static final String TAG = CryptodataRepository.class.getSimpleName();

    private CryptodataRemoteDataSource mRemoteDataSource;

    @Inject
    CryptodataRepository(@NonNull CryptodataRemoteDataSource remoteDataSource){
        mRemoteDataSource = remoteDataSource;
    }
    @Override
    public void getAll(loadCardsCallback callback) {
        mRemoteDataSource.getAll(callback);
    }

    @Override
    public void getOne(String id) {

    }

    @Override
    public void save(Card item) {

    }

    @Override
    public void update(Card item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
