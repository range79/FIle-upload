package com.range.Fileupload.Repo;

import com.range.Fileupload.model.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FIleRepository extends JpaRepository<MyFile,Long> {

}
