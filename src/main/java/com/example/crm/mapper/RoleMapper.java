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
    // ��������
    @Insert("INSERT INTO `role` (`name`) VALUE (#{name})") // #{}������ݽ���ת�� ${}��������ݽ���ת��
    // �������ݿ���������
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public Integer create(Role role);

    // �鵥����¼
    @Select("SELECT * FROM `role` WHERE `id`=#{rid}")
    public Role findById(@Param("rid") Integer id);

    // �������¼
    @Select("SELECT * FROM `role`")
    public List<Role> findAll();

    // ���ص���Ӱ���������``��������������ݿ���������������
    @Update("UPDATE `role` SET `name`=#{name} WHERE `id`=#{id}")
    public Integer update(Role role);

    @Delete("DELETE FROM `role` WHERE `id`=#{id}")
    public Integer remove(Role role);
}
