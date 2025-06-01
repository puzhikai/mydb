package org.zhikpu.engine.hdd.page;


public interface Page {
    int getPageId();
    byte[] serialize();
    void deserialize(byte[] data);
}
