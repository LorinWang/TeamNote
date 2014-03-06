package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface MenuDao
{
	Menu findByName(String name);
	
	long save(Menu menu);
	void update(Menu menu);
	void delete(Menu menu);
	/*Menu findById(long id);

	

	Menu findByDoc(Doc doc);

	

	

	

	

	List<Menu> findByUnfoldUser(User user);

	List<Menu> findByModifier(User modifier);

	List<Menu> findByOwner(User owner);

	List<Menu> findByGroup(UserGroup userGroup);
*/
	List<Menu> findAll();
}
