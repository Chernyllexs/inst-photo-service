package com.chernyllexs.photo.utill.mapper;

import com.chernyllexs.photo.entity.PhotoPostEntity;
import com.chernyllexs.photo.model.PhotoPostDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotoPostMapper {
    private final ModelMapper modelMapper;

    public PhotoPostMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PhotoPostDto convertToDto(PhotoPostEntity photoPostEntity){
        return modelMapper.map(photoPostEntity, PhotoPostDto.class );
    }

    public PhotoPostEntity convertToEntity(PhotoPostDto photoPostDto){
        return modelMapper.map(photoPostDto, PhotoPostEntity.class);
    }
}
