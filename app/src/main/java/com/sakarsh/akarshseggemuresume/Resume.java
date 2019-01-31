
package com.sakarsh.akarshseggemuresume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resume {

    @SerializedName("basics")
    @Expose
    private Basics basics;
    @SerializedName("work")
    @Expose
    private List<Work> work = null;
    @SerializedName("volunteer")
    @Expose
    private List<Volunteer> volunteer = null;
    @SerializedName("education")
    @Expose
    private List<Education> education = null;
    @SerializedName("awards")
    @Expose
    private List<Award> awards = null;
    @SerializedName("publications")
    @Expose
    private List<Publication> publications = null;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = null;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("interests")
    @Expose
    private List<Interest> interests = null;
    @SerializedName("references")
    @Expose
    private List<Reference> references = null;

    public Basics getBasics() {
        return basics;
    }

    public void setBasics(Basics basics) {
        this.basics = basics;
    }

    public List<Work> getWork() {
        return work;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

    public List<Volunteer> getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(List<Volunteer> volunteer) {
        this.volunteer = volunteer;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

}
