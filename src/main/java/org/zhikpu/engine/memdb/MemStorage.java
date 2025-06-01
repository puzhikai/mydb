package org.zhikpu.engine.memdb;

import org.zhikpu.engine.StorageEngine;

import java.util.concurrent.*;

public class MemStorage implements StorageEngine {
    private final ConcurrentMap<String, byte[]> storage =
            new ConcurrentHashMap<>(1024);

    @Override
    public void put(String key, byte[] value) {
        storage.put(key, value);
    }

    @Override
    public byte[] get(String key) {
        return storage.get(key);
    }

    @Override
    public void delete(String key) {
        storage.remove(key);
    }

    @Override
    public void close() {
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}
