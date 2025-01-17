package com.range.Fileupload.Repo;

import com.range.Fileupload.Model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FIleService extends JpaRepository<File,Long> {

}
