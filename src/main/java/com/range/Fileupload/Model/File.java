package com.range.Fileupload.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @Lob
    private byte data;
    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }




    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
