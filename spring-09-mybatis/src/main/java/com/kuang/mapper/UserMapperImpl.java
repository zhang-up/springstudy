package com.kuang.mapper;

import com.kuang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
	@Override
    public List<User> selectUser() {
		UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

		User user = new User(5,"小王","13165");

		mapper.addUser(user);
		mapper.deleteUser(4);

		return mapper.selectUser();
    }

	@Override
	public int addUser(User user) {
		UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
		return mapper.addUser(user);
	}

	@Override
	public int deleteUser(int id) {
		UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
		return mapper.deleteUser(id);
	}
}
