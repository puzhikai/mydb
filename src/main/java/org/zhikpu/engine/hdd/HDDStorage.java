package org.zhikpu.engine.hdd;

import org.zhikpu.engine.StorageEngine;
import org.zhikpu.engine.StorageException;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HDDStorage implements StorageEngine {
    private final Path storageDir;
    private final Lock fileLock = new ReentrantLock();

    public HDDStorage(String dirPath) throws StorageException {
        try {
            this.storageDir = Paths.get(dirPath);
            Files.createDirectories(storageDir);
        } catch (IOException e) {
            throw new StorageException("初始化失败", e);
        }
    }

    @Override
    public void put(String key, byte[] value) throws StorageException {
        fileLock.lock();
        try (OutputStream os = Files.newOutputStream(storageDir.resolve(key))) {
            os.write(value);
        } catch (IOException e) {
            throw new StorageException("写入失败: " + key, e);
        } finally {
            fileLock.unlock();
        }
    }

    @Override
    public byte[] get(String key) throws StorageException {
        try {
            return Files.readAllBytes(storageDir.resolve(key));
        } catch (IOException e) {
            throw new StorageException("读取失败: " + key, e);
        }
    }

    @Override
    public void delete(String key) throws StorageException {

    }

    @Override
    public void close() throws StorageException {

    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}

