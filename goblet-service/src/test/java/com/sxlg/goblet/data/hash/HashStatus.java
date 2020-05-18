package com.sxlg.goblet.data.hash;

import java.util.Arrays;

public class HashStatus {
    private String hashName;
    private long runTime;
    private int[] rate;
    private double[] hitRate;
    private double total;
    int size;
    public HashStatus() {
        this.rate = new int[32];
        this.hitRate = new double[32];
    }


    public void setHitRate(double hitRate) {
        this.hitRate[size++] = hitRate;
    }

    public long getRunTime() {
        return runTime;
    }

    @Override
    public String toString() {
        return "HashStatus{" +
                "hashName='" + hashName + '\'' +
                ", runTime=" + runTime +
                ", rate=" + Arrays.toString(rate) +
                ", hitRate=" + Arrays.toString(hitRate) +
                ", total=" + total +
                ", size=" + size +
                '}';
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public int[] getRate() {
        return rate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    public void setRate(int[] rate) {
        this.rate = rate;
    }

    public double[] getHitRate() {
        return hitRate;
    }

    public void setHitRate(double[] hitRate) {
        this.hitRate = hitRate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
