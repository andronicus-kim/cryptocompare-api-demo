package kim.andronicus.cryptoasus.data.models;

/**
 * Created by andronicus on 10/18/2017.
 */

public class Card {
    private String exchangeRate;
    private String currency;

    public Card() {
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
