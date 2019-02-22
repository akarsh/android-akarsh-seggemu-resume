package com.sakarsh.akarshseggemuresume;

class ResumeSchema {
    private int name;
    private int image;
    private Class<?> className;
    private String intentName;

    // Constructor is used to create an instance of ResumeSchema object
    public ResumeSchema(int name, int image, Class<?> className, String intentName) {
        this.name = name;
        this.image = image;
        this.className = className;
        this.intentName = intentName;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class<?> getClassName() {
        return className;
    }

    public void setClassName(Class<?> className) {
        this.className = className;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }
}
