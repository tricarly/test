package com.suyi.mapper;

import com.suyi.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Insert("insert into sys_role values(#{id},#{roleName},#{roleDesc})")
    public void save(Role role);
    @Select("select * from sys_role")
    public List<Role> list();
    @Select("select roleName from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{userId}")
    public List<String> findRoleNameByUserId(int userId);
    @Delete("delete from sys_user_role where roleId=#{roleId}")
    public void deleteUserAndRole(Long roleId);
    @Delete("delete from sys_role where id=#{roleId}")
    public void delete(Long roleId);
}
