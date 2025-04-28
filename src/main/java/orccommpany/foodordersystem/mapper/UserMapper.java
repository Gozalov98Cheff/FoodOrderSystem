package orccommpany.foodordersystem.mapper;

import orccommpany.foodordersystem.dto.UserDto;
import orccommpany.foodordersystem.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
