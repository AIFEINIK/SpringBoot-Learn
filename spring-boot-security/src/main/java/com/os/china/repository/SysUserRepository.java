package com.os.china.repository;

import com.os.china.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-17
 * @Version 1.0.0
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByUsername(String username);
}
