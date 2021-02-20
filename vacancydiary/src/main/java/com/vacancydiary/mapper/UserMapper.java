package com.vacancydiary.mapper;

import com.vacancydiary.entity.User;
import com.vacancydiary.entity.dto.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserDto userDto);

    UserDto map(User user);
}
