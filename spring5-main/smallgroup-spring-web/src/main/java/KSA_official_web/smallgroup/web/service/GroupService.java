package KSA_offical_web.smallgroup.web.service;

import KSA_offical_web.smallgroup.web.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.web.service.sdo.SmallGroupCdo;
import KSA_offical_web.smallgroup.web.shared.NameValueList;

import java.util.List;

public interface GroupService {
	//
	String registerGroup(SmallGroupCdo club);
	SmallGroup findGroupById(String id);
	List<SmallGroup> findGroupsByName(String name);
	List<SmallGroup> findAll();
	void modify(String groupId, NameValueList nameValues);
	void remove(String groupId);
}
