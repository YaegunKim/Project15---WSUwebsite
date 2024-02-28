package KSA_offical_web.smallgroup.spring.service.logic;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.GroupService;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;
import KSA_offical_web.smallgroup.spring.store.GroupStore;
import KSA_offical_web.smallgroup.spring.util.exception.NoSuchGroupException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceLogic implements GroupService {
    //
    private GroupStore groupStore;

    public GroupServiceLogic(GroupStore groupStore) {
        //
        this.groupStore = groupStore;
    }

    @Override
    public String registerGroup(SmallGroupCdo groupCdo) {
        //
        SmallGroup group = new SmallGroup(groupCdo.getName(), groupCdo.getIntro());
        group.checkValidation();
        String groupId = groupStore.create(group);
        return groupId;
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
    public List<SmallGroup> findAll(){
        return groupStore.retrieveAll();
    }
    @Override
    public void modify(String groupId, NameValueList nameValueList) {
        SmallGroup smallGroup = groupStore.retrieve(groupId);
        if (smallGroup == null) {
            throw new NoSuchGroupException("No such group with id " + groupId);
        }
        smallGroup.modifyValues(nameValueList);
        groupStore.update(smallGroup);
    }

    @Override
    public void remove(String groupId) {
        if (!groupStore.exists(groupId)) {
            throw new NoSuchGroupException("No such group with id " + groupId);
        }
        groupStore.delete(groupId);
    }
}
