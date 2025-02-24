package com.range.fileupload.service;

import java.io.FileNotFoundException;

public interface FileDownloadService {
    byte[] downloadFile(String fileName) throws FileNotFoundException;



}



