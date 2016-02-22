package me.nithanim.cultures.format.lib;

import org.apache.commons.lang.builder.ToStringBuilder;

public class DirMeta {
    private final String name;
    private final int level;

    DirMeta(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
