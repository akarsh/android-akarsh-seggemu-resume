
package com.sakarsh.akarshseggemuresume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("fluency")
    @Expose
    private String fluency;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFluency() {
        return fluency;
    }

    public void setFluency(String fluency) {
        this.fluency = fluency;
    }

}
