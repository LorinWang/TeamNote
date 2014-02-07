package teamnote.dao;

import java.util.List;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface DocDao
{
	Doc findById(long id);

	Doc findByName(String name);

	long save(Doc doc);

	void update(Doc doc);

	void delete(Doc doc);

	List<Doc> findAll();
	
	List<Doc> findByMenu(Menu menu);
	List<Doc> findByOwner(User owner);
	List<Doc> findByGroup(UserGroup userGroup);
	
	List<Doc> findByReader(User reader);
	List<Doc> findByWriter(User writer);
	List<Doc> findByModifier(User modifier);
	
	
}
