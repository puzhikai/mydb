package org.zhikpu.engine;


public interface StorageEngine {
    void put(String key, byte[] value) throws StorageException;
    byte[] get(String key) throws StorageException;
    void delete(String key) throws StorageException;
    boolean containsKey(String key);
    void close() throws StorageException;

}

