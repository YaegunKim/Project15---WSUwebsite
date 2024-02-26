package KSA_offical_web.smallgroup.spring.store.mapstore;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.store.GroupStore;

import java.util.*;
import java.util.stream.Collectors;

public class GroupMapStore implements GroupStore {

    private Map<String, SmallGroup> groupMap;

    public GroupMapStore() {
        this.groupMap = new LinkedHashMap<>();
    }

    @Override
    public String create(SmallGroup group) {
        groupMap.put(group.getId(), group);
        return group.getId();
    }

    @Override
    public SmallGroup retrieve(String groupId) {
        return groupMap.get(groupId);
    }

    @Override
    public List<SmallGroup> retrieveByName(String name) {
        return groupMap.values().stream()
                .filter(group -> group.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void update(SmallGroup group) {
		groupMap.put(group.getId(), group);
    }

    @Override
    public void delete(String groupId) {
		groupMap.remove(groupId);
    }

    @Override
    public boolean exists(String groupId) {
//        return groupMap.containsKey(groupId);
        return Optional.ofNullable(groupMap.get(groupId)).isPresent();
    }
}