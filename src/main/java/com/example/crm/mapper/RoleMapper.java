package com.example.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

import com.example.crm.controller.entity.Role;

@Mapper
public interface RoleMapper {
    // 单条插入
    @Insert("INSERT INTO `role` (`name`) VALUE (#{name})") // #{}会对内容进行转译 ${}不会对内容进行转译
    // 设置数据库自增数据
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public Integer create(Role role);

    // 查单条记录
    @Select("SELECT * FROM `role` WHERE `id`=#{rid}")
    public Role findById(@Param("rid") Integer id);

    // 查多条记录
    @Select("SELECT * FROM `role`")
    public List<Role> findAll();

    // 返回的是影响的行数，``里面的内容是数据库名、表名、列名
    @Update("UPDATE `role` SET `name`=#{name} WHERE `id`=#{id}")
    public Integer update(Role role);

    @Delete("DELETE FROM `role` WHERE `id`=#{id}")
    public Integer remove(Role role);
}
