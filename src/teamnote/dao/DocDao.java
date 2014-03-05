package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface DocDao
{
	long save(Doc doc);
	Doc findByName(String name);
	void delete(Doc doc);
	/*Doc findById(long id);

	Doc findByName(String name);

	

	void update(Doc doc);

	

	List<Doc> findAll();

	List<Doc> findByMenu(Menu menu);

	List<Doc> findByOwner(User owner);

	List<Doc> findByGroup(UserGroup userGroup);

	List<Doc> findByReader(User reader);

	List<Doc> findByWriter(User writer);

	List<Doc> findByModifier(User modifier);
*/

}
