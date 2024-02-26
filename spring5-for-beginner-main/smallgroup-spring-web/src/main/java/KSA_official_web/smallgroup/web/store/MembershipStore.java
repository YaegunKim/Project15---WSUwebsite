package KSA_offical_web.smallgroup.web.store;

import KSA_offical_web.smallgroup.web.aggregate.group.Membership;

import java.util.List;

public interface MembershipStore {
    //
    String create(Membership membership);
    Membership retrieve(String membershipId);
    Membership retrieveByGroupIdAndMemberId(String groupId, String memberId);
    List<Membership> retrieveByGroupId(String groupId);
    List<Membership> retrieveByMemberId(String memberId);
    void update(Membership membership);
    void delete(String membershipId);

    boolean exists(String membershipId);
}
