package com.range.fileupload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Document(collection = "files")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class MyFile {
    @Id
    private Long fileId;
    private String fileName;
    private String fileType;
    private Long filesize;
    private byte[] fileData;
}

