package com.chernyllexs.photo.api;

import com.chernyllexs.photo.model.entity.PhotoAvatarEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAvatarRepository extends CrudRepository<PhotoAvatarEntity, String> {
    int deleteByAvatarId(String avatarId);
}
