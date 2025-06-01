package org.zhikpu.engine.hdd.page;

import java.util.Map;

class LeafPage implements Page {
    private int pageId;
    private Map<Comparable, byte[]> records;

    @Override public int getPageId() { return pageId; }
    @Override public byte[] serialize() { /* 序列化逻辑 */ return new byte[0]; }
    @Override public void deserialize(byte[] data) { /* 反序列化逻辑 */ }
}

