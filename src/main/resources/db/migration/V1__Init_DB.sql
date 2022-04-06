/*create table post_photos
(
    photo_post_id       int8 generated by default as identity,
    photo_name          varchar(255) not null,
    primary key (photo_post_id)
);

create table avatar_photos
(
    photo_avatar_id     int8 generated by default as identity,
    photo_name          varchar(255) not null,
    user_id             varchar(255),
    primary key (photo_avatar_id)
);*/


create table avatar_photos
(
    photo_avatar_id varchar(255) not null,
    primary key (photo_avatar_id)
);

create table post_photos
(
    photo_post_id varchar(255) not null,
    primary key (photo_post_id)
);