package com.range.fileupload.file.Repo;

import com.range.fileupload.file.model.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FIleRepository extends JpaRepository<MyFile,Long> {
   MyFile getFileByFileName(String fileName);
}
