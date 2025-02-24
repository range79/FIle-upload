package com.range.fileupload.filerepo;

import com.range.fileupload.model.MyFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface FileRepository extends MongoRepository<MyFile,String> {
    MyFile getMyFileByFileName(String fileName);
}
