package KSA_offical_web.smallgroup.spring.service;

import KSA_offical_web.smallgroup.spring.aggregate.group.Membership;
import KSA_offical_web.smallgroup.spring.service.sdo.MembershipCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;

import java.util.List;

public interface MembershipService {
    //
    String registerMembership(MembershipCdo membershipCdo);
    Membership findMembership(String membershipId);
    Membership findMembershipByGroupIdAndMemberId(String groupId, String memberId);
    Membership findMembershipByGroupIdAndMemberEmail(String groupId, String memberEmail);
    List<Membership> findAllMembershipsOfGroup(String groupId);
    List<Membership> findAllMembershipsOfMember(String memberId);
    void modifyMembership(String membershipId, NameValueList nameValueList);
    void removeMembership(String membershipId);
}
