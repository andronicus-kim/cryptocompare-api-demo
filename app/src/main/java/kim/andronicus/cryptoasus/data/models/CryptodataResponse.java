
package kim.andronicus.cryptoasus.data.models;

import com.google.gson.annotations.SerializedName;

public class CryptodataResponse {

    @SerializedName("USD")
    private Double mUSD;

    public Double getUSD() {
        return mUSD;
    }

    public void setUSD(Double USD) {
        mUSD = USD;
    }

}
