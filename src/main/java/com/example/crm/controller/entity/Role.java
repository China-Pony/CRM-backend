package com.example.crm.controller.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Role {

	@NotNull // 设置字段不能为空
	@Min(1) // 字段最小值为1
	private Integer id;

	@NotBlank // 给字符串用的
	@Size(min = 1, max = 32) // 单位：字符
	private String name;

}
