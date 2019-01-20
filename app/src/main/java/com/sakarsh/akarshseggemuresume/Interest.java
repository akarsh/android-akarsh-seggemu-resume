
package com.sakarsh.akarshseggemuresume;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interest {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

}
