package KSA_offical_web.smallgroup.spring.service.logic;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.GroupService;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;
import KSA_offical_web.smallgroup.spring.store.GroupStore;
import KSA_offical_web.smallgroup.spring.store.mapstore.GroupMapStore;

import java.util.List;

public class GroupServiceLogic implements GroupService {

    private GroupStore groupStore;

    public GroupServiceLogic(){
        this.groupStore = new GroupMapStore();
    }

    @Override
    public String registerGroup(SmallGroupCdo group) {
        groupStore.create();
        return null;
    }

    @Override
    public SmallGroup findGroupById(String id) {
        return null;
    }

    @Override
    public List<SmallGroup> findGroupsByName(String name) {
        return null;
    }

    @Override
    public void modify(String groupId, NameValueList nameValues) {

    }

    @Override
    public void remove(String groupId) {

    }
}
