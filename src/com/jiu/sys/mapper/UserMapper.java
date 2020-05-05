package com.jiu.sys.mapper;

import com.jiu.sys.domain.User;
import com.jiu.sys.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 登录
	 */
	User login(UserVo userVo);

	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	List<User> queryAllUser(User user);

	/**
	 * 保存用户和角色间的关系
	 * @param userid
	 * @param rid
	 */
    void insertUserRole(@Param("uid") Integer userid, @Param("rid") Integer rid);

	/**
	 * 根据用户名修改密码
	 * @param uname
	 * @param pwd
	 */
	void changePwd(@Param("uname") String uname, @Param("pwd") String pwd);

}
