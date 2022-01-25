package com.chernyllexs.photo.utill.mapper;

import com.chernyllexs.photo.entity.PhotoAvatarEntity;
import com.chernyllexs.photo.model.PhotoAvatarDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotoAvatarMapper {
    private final ModelMapper modelMapper;

    public PhotoAvatarMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PhotoAvatarDto convertToDto(PhotoAvatarEntity photoAvatarEntity){
        return modelMapper.map(photoAvatarEntity, PhotoAvatarDto.class );
    }

    public PhotoAvatarEntity convertToEntity(PhotoAvatarDto photoAvatarDto){
        return modelMapper.map(photoAvatarDto, PhotoAvatarEntity.class);
    }
}
