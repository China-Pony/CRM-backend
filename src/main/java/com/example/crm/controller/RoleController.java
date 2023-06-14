package com.example.crm.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.controller.entity.Role;
import com.example.crm.mapper.RoleMapper;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }) // 允许跨域请求，有安全风险，本地开发可以用，网络开发不要用
public class RoleController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private RoleMapper roleMapper;

	@PostMapping("/role/create")
	public HashMap<String, Object> create(
			Role role) {
		HashMap<String, Object> result = new HashMap<>();
		// result = HashMap = new HashMap<>();

		// 创建Role对象并设置name值
		// Role role = new Role();
		// role.setName("");
		// RoleMapper的create方法保存role对象属性至数据库
		this.roleMapper.create(role);

		this.log.info(role);
		result.put("status", true);

		return result;
	}

	@GetMapping("/role/{id}")
	public HashMap<String, Object> fetch(
			@PathVariable("id") Integer id) {
		HashMap<String, Object> result = new HashMap<>();

		Role role = this.roleMapper.findById(id);

		// this.log.info(role);
		result.put("payload", role);
		return result;
	}

	@GetMapping("/role")
	public HashMap<String, Object> index() {
		HashMap<String, Object> result = new HashMap<>();

		List<Role> roles = this.roleMapper.findAll();

		this.log.info(roles);
		result.put("payload", roles);
		// for (Role role : roles) {

		// }
		return result;
	}

	// 绑定post方式的请求
	// 前端传过来的数据会自动填充到Role role当中去
	@PostMapping("/role/update/{id}")
	public HashMap<String, Object> update(
			@PathVariable("id") Integer id,
			Role fields,
			BindingResult bindingResult) {
		HashMap<String, Object> result = new HashMap<>();

		try {
			if (bindingResult.hasErrors()) {
				throw new IllegalArgumentException("输入数据有误！");
			}
			Role role = this.roleMapper.findById(id);
			if (role == null)
				throw new IllegalArgumentException("参数【ID】无效");

			role.setName(fields.getName());

			this.roleMapper.update(role);

			result.put("date", role);
			result.put("status", true);
		} catch (Exception exception) {
			result.put("status", false);
		}

		return result;
	}

	@PostMapping("/role/remove/{id}")
	public HashMap<String, Object> remove(
			@RequestParam("id") Integer id) {
		HashMap<String, Object> result = new HashMap<>();

		try {
			Role role = this.roleMapper.findById(id);
			if (role == null) {
				throw new IllegalArgumentException("参数【id】无效！！");
			}
			this.roleMapper.remove(role);

			result.put("status", true);
		} catch (Exception exception) {
			exception.printStackTrace();
			result.put("status", false);
		}

		return result;
	}

}
