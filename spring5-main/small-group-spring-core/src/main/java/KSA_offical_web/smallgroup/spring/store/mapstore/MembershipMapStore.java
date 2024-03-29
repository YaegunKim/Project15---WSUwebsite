package KSA_offical_web.smallgroup.spring.store.mapstore;

import KSA_offical_web.smallgroup.spring.aggregate.group.Membership;
import KSA_offical_web.smallgroup.spring.store.MembershipStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MembershipMapStore implements MembershipStore {
	//
	private Map<String, Membership> membershipMap;

	public MembershipMapStore() {
		//
		this.membershipMap = new LinkedHashMap<>();
	}

	@Override
	public String create(Membership membership) {
		//
		membershipMap.put(membership.getId(), membership);
		return membership.getId();
	}

	@Override
	public Membership retrieve(String membershipId) {
		//
		return membershipMap.get(membershipId);
	}

	@Override
	public Membership retrieveByGroupIdAndMemberId(String groupId, String memberId) {
		//
		Membership targetMembership = null;

		for (Membership membership : membershipMap.values()) {
			if (membership.getGroupId().equals(groupId) && membership.getMemberId().equals(memberId)) {
				targetMembership = membership;
				break;
			}
		}

		return targetMembership;
	}

	@Override
	public List<Membership> retrieveByGroupId(String groupId) {
		//
		return membershipMap.values().stream()
				.filter(membership -> membership.getGroupId().equals(groupId))
				.collect(Collectors.toList());
	}

	@Override
	public List<Membership> retrieveByMemberId(String memberId) {
		//
		return membershipMap.values().stream()
				.filter(membership -> membership.getMemberId().equals(memberId))
				.collect(Collectors.toList());
	}

	@Override
	public void update(Membership membership) {
		//
		membershipMap.put(membership.getId(), membership);
	}

	@Override
	public void delete(String membershipId) {
		//
		membershipMap.remove(membershipId);
	}

	@Override
	public boolean exists(String membershipId) {
		//
		return Optional.ofNullable(retrieve(membershipId)).isPresent();
	}
}
