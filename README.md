# PHOTO SERVICE

#### Function:
* Uploading a photo for a post:
    * Decrease in width resolution;
    * Saving in a local directory;
* Getting photos for a post by photoId;
* Deleting photos for a post by photoId;

* Uploading an avatar photo:
    * Decrease in width resolution;
    * Saving in a local directory;
* Getting photos for the user's avatar by avatarId;
* Deleting photos for the user's avatar by avatarId;

#### Endpoints:
* GET /photo/get-avatars;
* GET /photo/get-avatar-photo/{photoId};
* POST /photo/avatar-upload-img;
* DELETE /photo/delete-avatar-photo/{avatarId};

* GET /photo/get-post-photos;
* GET /photo/get-post-photo/{id};
* POST /photo/post-upload-img;
* DELETE /photo/delete-post-photo/{id};

#### DTOs:
* PhotoAvatarDto
    * Long avatarId;
* PhotoPostDto
    * Long photoId;