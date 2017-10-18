
package kim.andronicus.cryptoasus.data.models;

import com.google.gson.annotations.SerializedName;

public class CryptodataResponse {

    @SerializedName("CNY")
    private Double mCNY;

    public Double getCNY() {
        return mCNY;
    }

    public void setCNY(Double CNY) {
        mCNY = CNY;
    }
}
