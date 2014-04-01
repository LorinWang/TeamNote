package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface UserDao
{
	User findById(long id);

	User findByName(String name);

	User findByNameAndPass(User user);

	void update(User user);
	
	long save(User user);
	
	List<User> findAll();
	/*User findByMenuOwner(Menu menu);

	User findByDocOwner(Doc doc);

	User findByGroupOwner(UserGroup userGroup);

	User findByMenuModifier(Menu menu);

	User findByDocWriter(Doc doc);

	User findByDocModifier(Doc doc);

	long save(User user);

	

	void delete(User user);

	List<User> findAll();

	List<User> findByUnfoldMenu(Menu menu);

	List<User> findByDocReader(Doc doc);

	List<User> findByUserGroup(UserGroup userGroup);*/


}
