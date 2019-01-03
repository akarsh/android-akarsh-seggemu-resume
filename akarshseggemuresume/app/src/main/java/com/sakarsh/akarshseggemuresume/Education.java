
package com.sakarsh.akarshseggemuresume;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Education {

    @SerializedName("institution")
    @Expose
    private String institution;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("studyType")
    @Expose
    private String studyType;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("gpa")
    @Expose
    private String gpa;
    @SerializedName("courses")
    @Expose
    private List<Object> courses = null;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
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

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public List<Object> getCourses() {
        return courses;
    }

    public void setCourses(List<Object> courses) {
        this.courses = courses;
    }

}
