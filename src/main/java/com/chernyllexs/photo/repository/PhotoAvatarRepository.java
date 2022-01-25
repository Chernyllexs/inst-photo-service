package com.chernyllexs.photo.repository;

import com.chernyllexs.photo.entity.PhotoAvatarEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAvatarRepository extends CrudRepository <PhotoAvatarEntity, Long> {
}
