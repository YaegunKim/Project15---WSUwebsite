package KSA_offical_web.smallgroup.web.service.logic;

import KSA_offical_web.smallgroup.web.aggregate.group.CommunityMember;
import KSA_offical_web.smallgroup.web.aggregate.group.Membership;
import KSA_offical_web.smallgroup.web.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.web.aggregate.group.vo.RoleInGroup;
import KSA_offical_web.smallgroup.web.service.MembershipService;
import KSA_offical_web.smallgroup.web.service.sdo.MembershipCdo;
import KSA_offical_web.smallgroup.web.shared.NameValueList;
import KSA_offical_web.smallgroup.web.store.GroupStore;
import KSA_offical_web.smallgroup.web.store.MemberStore;
import KSA_offical_web.smallgroup.web.store.MembershipStore;
import KSA_offical_web.smallgroup.web.util.exception.MembershipDuplicationException;
import KSA_offical_web.smallgroup.web.util.exception.NoSuchGroupException;
import KSA_offical_web.smallgroup.web.util.exception.NoSuchMemberException;
import KSA_offical_web.smallgroup.web.util.exception.NoSuchMembershipException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceLogic implements MembershipService {
    //
    private MembershipStore membershipStore;
    private GroupStore groupStore;
    private MemberStore memberStore;

    public MembershipServiceLogic(MembershipStore membershipStore,
                                  GroupStore groupStore,
                                  MemberStore memberStore) {
        //
        this.membershipStore = membershipStore;
        this.memberStore = memberStore;
        this.groupStore = groupStore;
    }

    @Override
    public String registerMembership(MembershipCdo membershipCdo) {
        //
        String groupId = membershipCdo.getGroupId();
        String memberId = membershipCdo.getMemberId();
        RoleInGroup role = membershipCdo.getRole();

        SmallGroup group = groupStore.retrieve(groupId);

        if (group == null) {
            throw new NoSuchGroupException("No such group with id " + groupId);
        }

        CommunityMember member = memberStore.retrieve(memberId);

        if (member == null) {
            throw new NoSuchMemberException("No such member with id " + memberId);
        }

        Membership membership = findMembershipByGroupIdAndMemberId(groupId, memberId);

        if (membership != null) {
            throw new MembershipDuplicationException("Member already exists in the group");
        }

        membership = new Membership(groupId, memberId);
        membership.setRole(role);

        String membershipId = membershipStore.create(membership);

        return membershipId;
    }

    @Override
    public Membership findMembership(String membershipId) {
        //
        return membershipStore.retrieve(membershipId);
    }

    @Override
    public Membership findMembershipByGroupIdAndMemberId(String groupId, String memberId) {
        //
        return membershipStore.retrieve(groupId);
    }

    @Override
    public Membership findMembershipByGroupIdAndMemberEmail(String groupId, String memberEmail) {
        //
        CommunityMember member = memberStore.retrieveByEmail(memberEmail);

        if (member == null) {
            throw new NoSuchMemberException("No such member with email " + memberEmail);
        }

        Membership membership = findMembershipByGroupIdAndMemberId(groupId, member.getId());
        return membership;
    }

    @Override
    public List<Membership> findAllMembershipsOfGroup(String groupId) {
        //
        return membershipStore.retrieveByGroupId(groupId);
    }

    @Override
    public List<Membership> findAllMembershipsOfMember(String memberId) {
        //
        return membershipStore.retrieveByMemberId(memberId);
    }

    @Override
    public void modifyMembership(String membershipId, NameValueList nameValueList) {
        //
        Membership membership = membershipStore.retrieve(membershipId);

        if (membership == null) {
            throw new NoSuchMembershipException("No such membership");
        }

        membership.modifyValues(nameValueList);

        membershipStore.update(membership);
    }

    @Override
    public void removeMembership(String membershipId) {
        //
        membershipStore.delete(membershipId);
    }
}
