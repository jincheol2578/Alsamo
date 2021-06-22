package com.koreait.alsamo.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity param);
    UserEntity selUser(UserEntity param);

    int insGoogleUser(UserEntity param);

    UserEntity checkSocialUserExsist(UserEntity param);
    UserEntity chckAuthkey(UserEntity param);
    int upAuthorize(UserEntity param);
}