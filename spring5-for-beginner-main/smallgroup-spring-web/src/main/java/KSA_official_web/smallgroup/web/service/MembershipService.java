package KSA_offical_web.smallgroup.web.service;

import KSA_offical_web.smallgroup.web.aggregate.club.Membership;
import KSA_offical_web.smallgroup.web.service.sdo.MembershipCdo;
import KSA_offical_web.smallgroup.web.shared.NameValueList;

import java.util.List;

public interface MembershipService {
    //
    String registerMembership(MembershipCdo membershipCdo);
    Membership findMembership(String membershipId);
    Membership findMembershipByClubIdAndMemberId(String clubId, String memberId);
    Membership findMembershipByClubIdAndMemberEmail(String clubId, String memberEmail);
    List<Membership> findAllMembershipsOfClub(String clubId);
    List<Membership> findAllMembershipsOfMember(String memberId);
    void modifyMembership(String membershipId, NameValueList nameValueList);
    void removeMembership(String membershipId);
}
