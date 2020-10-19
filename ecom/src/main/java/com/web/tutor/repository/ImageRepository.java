package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.tutor.model.ImageFiles;


@Repository
public interface ImageRepository extends JpaRepository<ImageFiles, Long>{

}
