package KSA_offical_web.smallgroup.spring.service.logic;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.GroupService;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;
import KSA_offical_web.smallgroup.spring.store.GroupStore;
import KSA_offical_web.smallgroup.spring.store.mapstore.GroupMapStore;
import KSA_offical_web.smallgroup.spring.util.exception.NoSuchGroupException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceLogic implements GroupService {

    private GroupStore groupStore;


    public GroupServiceLogic(GroupMapStore groupStore) {
        this.groupStore = groupStore;
    }

    @Override
    public String registerGroup(SmallGroupCdo group) {
        SmallGroup newGroup = new SmallGroup(group.getName(), group.getIntro());
        newGroup.checkValidation();
        return groupStore.create(newGroup);
    }

    @Override
    public SmallGroup findGroupById(String id) {
        return groupStore.retrieve(id);
    }

    @Override
    public List<SmallGroup> findGroupsByName(String name) {
        return groupStore.retrieveByName(name);
    }

    @Override
    public void modify(String groupId, NameValueList nameValues) {
        SmallGroup groupFound = groupStore.retrieve(groupId);
        if(groupFound == null){
            throw new NoSuchGroupException("There is no such club with id: " + groupId);
        }
        groupFound.modifyValues(nameValues);
        groupStore.update(groupFound);
    }

    @Override
    public void remove(String groupId) {
        if(!groupStore.exists(groupId)){
            throw new NoSuchGroupException("There is no such club with id: " + groupId);
        }
        groupStore.delete(groupId);
    }
}
