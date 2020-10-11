package com.suyi.mapper;

import com.suyi.domain.Role;
import com.suyi.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from sys_user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "id",property = "rolename",
                    javaType = List.class,
                    many = @Many(select = "com.suyi.mapper.RoleMapper.findRoleNameByUserId")
            )
    })
    public List<User> list();
    @Insert("insert into sys_user values(#{id},#{username},#{email},#{password},#{phoneNum})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void save(User user);
    @Insert("insert into sys_user_role values(#{userId},#{roleId})")
    public void saveUserAndRole(@Param("userId") Long id,@Param("roleId") Long roleId);
    @Delete("delete from sys_user_role where userId=#{userId}")
    public void deleteUserAndRole(Long userId);
    @Delete("delete from sys_user where id=#{userId}")
    public void delete(Long userId);
    @Select("select * from sys_user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
