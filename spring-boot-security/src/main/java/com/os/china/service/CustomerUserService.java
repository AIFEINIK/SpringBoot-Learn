package com.os.china.service;

import com.os.china.entity.SysUser;
import com.os.china.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-17
 * @Version 1.0.0
 */
public class CustomerUserService implements UserDetailsService {

	@Autowired
	SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在!");
		}
		return user;
	}
}
