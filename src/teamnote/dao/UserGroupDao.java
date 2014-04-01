package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface UserGroupDao
{
	UserGroup findByName(String name);
	
	List<UserGroup> findAll();
	/*UserGroup findById(long id);

	

	UserGroup findByMenuOwner(Menu menu);

	UserGroup findByDocOwner(Doc doc);

	List<UserGroup> findByGroupOwner(User user);

	long save(UserGroup userGroup);

	void update(UserGroup userGroup);

	void delete(UserGroup userGroup);

	List<UserGroup> findAll();

	List<UserGroup> findByUser(User user);*/
}
