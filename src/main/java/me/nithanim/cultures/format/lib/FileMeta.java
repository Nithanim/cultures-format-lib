package me.nithanim.cultures.format.lib;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FileMeta {
    private final String name;
    private final int pos;
    private final int len;

    FileMeta(String name, int pos, int len) {
        this.name = name;
        this.pos = pos;
        this.len = len;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public int getLen() {
        return len;
    }

    public String getFileExtension() {
        int i = name.lastIndexOf('.');
        return i == -1 ? null : name.substring(i + 1);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
