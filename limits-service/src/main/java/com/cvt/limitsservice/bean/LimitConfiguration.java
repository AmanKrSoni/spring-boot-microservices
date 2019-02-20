package com.cvt.limitsservice.bean;

public class LimitConfiguration {
    private int maxmimum;
    private int minimum;

    public LimitConfiguration() {
    }

    public LimitConfiguration(int maxmimum, int minimum) {
        this.maxmimum = maxmimum;
        this.minimum = minimum;
    }

    public int getMaxmimun() {
        return maxmimum;
    }

    public void setMaxmimun(int maxmimun) {
        this.maxmimum = maxmimun;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "LimitConfiguration{" +
                "maxmimun=" + maxmimum +
                ", minimum=" + minimum +
                '}';
    }
}
