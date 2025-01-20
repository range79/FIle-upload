package com.range.fileupload.file.Mapper;

import com.range.fileupload.file.model.MyFile;

import java.util.List;
import java.util.stream.Collectors;

public class FileMapper {

    public List<String> getFilesname(List<MyFile> files) {
        return files.stream()
                .map(MyFile::getFileName)
                .collect(Collectors.toList());
    }

}
