package com.chernyllexs.photo.api;

import com.chernyllexs.photo.model.entity.PhotoPostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoPostRepository extends CrudRepository<PhotoPostEntity, String> {
    int deleteByPhotoId(String photoId);
}
