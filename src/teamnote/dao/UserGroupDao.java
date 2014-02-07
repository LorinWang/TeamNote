package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface UserGroupDao
{
	UserGroup findById(long id);

	UserGroup findByName(String name);

	UserGroup findByMenuOwner(Menu menu);

	UserGroup findByDocOwner(Doc doc);

	UserGroup findByGroupOwner(User user);

	long save(UserGroup userGroup);

	void update(UserGroup userGroup);

	void delete(UserGroup userGroup);

	List<UserGroup> findAll();

	List<UserGroup> findByUser(User user);
}
