package com.range.fileupload.mapper;

import com.range.fileupload.model.MyFile;

import java.util.List;
import java.util.stream.Collectors;

public class FileMapper {

    public List<String> getFilesname(List<MyFile> files) {
        return files.stream()
                .map(MyFile::getFileName)
                .collect(Collectors.toList());
    }

}
