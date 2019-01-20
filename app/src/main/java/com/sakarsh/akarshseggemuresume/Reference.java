
package com.sakarsh.akarshseggemuresume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reference {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("reference")
    @Expose
    private String reference;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
