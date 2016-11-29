package org.hf.jsem.keypool;

/**
 * Created by adramer on 2016/11/9.
 */
public class Key {
    private String name;
    private long pk;
    private long nextValue;
    private long maxKey;

    public String getName() {
        return name;
    }

    public long getPk() {
        return pk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public long getNextValue() {
        return nextValue;
    }

    public void setNextValue(long nextValue) {
        this.nextValue = nextValue;
    }

    public long getMaxKey() {
        return maxKey;
    }

    public void setMaxKey(long maxKey) {
        this.maxKey = maxKey;
    }
}
