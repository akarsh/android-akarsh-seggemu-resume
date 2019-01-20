
package com.sakarsh.akarshseggemuresume;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volunteer {

    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("highlights")
    @Expose
    private List<Object> highlights = null;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Object> highlights) {
        this.highlights = highlights;
    }

}
