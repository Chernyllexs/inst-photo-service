package com.chernyllexs.photo.repository;

import com.chernyllexs.photo.entity.PhotoPostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoPostRepository extends CrudRepository<PhotoPostEntity, Long> {
}
