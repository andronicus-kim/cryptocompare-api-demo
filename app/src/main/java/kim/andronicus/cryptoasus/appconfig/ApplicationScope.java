package kim.andronicus.cryptoasus.appconfig;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by andronicus on 10/17/2017.
 */
@Scope
@Documented()
@Retention(RetentionPolicy.CLASS)
public @interface ApplicationScope {
}
