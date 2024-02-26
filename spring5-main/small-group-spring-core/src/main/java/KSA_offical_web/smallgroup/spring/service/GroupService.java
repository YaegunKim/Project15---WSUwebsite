package KSA_offical_web.smallgroup.spring.service;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;

import java.util.List;

public interface GroupService {
	//
	String registerGroup(SmallGroupCdo group);
	SmallGroup findGroupById(String id);
	List<SmallGroup> findGroupsByName(String name);
	void modify(String groupId, NameValueList nameValues);
	void remove(String groupId);
}
