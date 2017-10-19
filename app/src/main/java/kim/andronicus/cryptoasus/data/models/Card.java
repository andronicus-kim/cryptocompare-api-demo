package kim.andronicus.cryptoasus.data.models;

/**
 * Created by andronicus on 10/18/2017.
 */

public class Card {
    private String exchangeRateBTC;
    private String exchangeRateETH;
    private String currency;

    public Card() {
    }

    public String getExchangeRateBTC() {
        return exchangeRateBTC;
    }

    public void setExchangeRateBTC(String exchangeRateBTC) {
        this.exchangeRateBTC = exchangeRateBTC;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchangeRateETH() {
        return exchangeRateETH;
    }

    public void setExchangeRateETH(String exchangeRateETH) {
        this.exchangeRateETH = exchangeRateETH;
    }
}
