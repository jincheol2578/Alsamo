package com.koreait.alsamo.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity param);

    UserEntity selUser(UserEntity param);

    int insGoogleUser(UserEntity param);

    UserEntity chckAuthkey(UserEntity param);

    int upAuth_no(UserEntity param);

    int updUser(UserEntity param);

    UserEntity selId(UserEntity param);

    int updMark(UserEntity param);

    String  selNowMark(int authNo);

}