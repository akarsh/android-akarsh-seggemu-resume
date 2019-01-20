
package com.sakarsh.akarshseggemuresume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Publication {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("summary")
    @Expose
    private String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
