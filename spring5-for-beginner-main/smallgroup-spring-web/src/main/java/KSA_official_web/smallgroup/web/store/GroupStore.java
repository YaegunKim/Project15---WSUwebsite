package KSA_offical_web.smallgroup.web.store;

import KSA_offical_web.smallgroup.web.aggregate.group.SmallGroup;

import java.util.List;

public interface GroupStore {
	//
	String create(SmallGroup group);
	SmallGroup retrieve(String groupId);
	List<SmallGroup> retrieveByName(String name);
	List<SmallGroup> retrieveAll();
	void update(SmallGroup group);
	void delete(String groupId);

	boolean exists(String groupId);
}
