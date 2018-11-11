package com.builder.schedule.demo.excel;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class DataLoaderImpl implements DataLoaderService {
    @Override
    public void init() {
        //todo
    }

    @Override
    public void store(MultipartFile file) {
        //todo
    }

    @Override
    public Stream<Path> loadAll() {
        //todo
        return null;
    }

    @Override
    public Path load(String filename) {
        //todo
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        //todo
        return null;
    }

    @Override
    public void deleteAll() {
        //todo
    }
}