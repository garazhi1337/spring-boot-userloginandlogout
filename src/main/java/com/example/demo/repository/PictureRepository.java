package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface PictureRepository extends JpaRepository<Picture, Long>{

}
