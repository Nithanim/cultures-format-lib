package me.nithanim.cultures.format.lib;

public class Header {
    private int unknown;
    private int dirCount;
    private int fileCount;

    public Header(int unknown, int dirCount, int fileCount) {
        this.unknown = unknown;
        this.dirCount = dirCount;
        this.fileCount = fileCount;
    }

    public int getUnknown() {
        return unknown;
    }

    public int getDirCount() {
        return dirCount;
    }

    public int getFileCount() {
        return fileCount;
    }
}
