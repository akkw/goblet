package com.sxlg.goblet.service.config;

public class Property {
    private String name;
    private String key;
    private String value;
    private int versions;

    public Property(String name, String key, String value, int versions) {
        this.name = name;
        this.key = key;
        this.value = value;
        this.versions = versions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getVersions() {
        return versions;
    }

    public void setVersions(int versions) {
        this.versions = versions;
    }
}
