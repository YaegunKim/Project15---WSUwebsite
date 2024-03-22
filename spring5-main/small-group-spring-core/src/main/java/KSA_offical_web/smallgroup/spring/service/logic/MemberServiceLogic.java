package KSA_offical_web.smallgroup.spring.service.logic;

import KSA_offical_web.smallgroup.spring.aggregate.group.CommunityMember;
import KSA_offical_web.smallgroup.spring.service.MemberService;
import KSA_offical_web.smallgroup.spring.service.sdo.MemberCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;
import KSA_offical_web.smallgroup.spring.store.MemberStore;
import KSA_offical_web.smallgroup.spring.util.exception.MemberDuplicationException;
import KSA_offical_web.smallgroup.spring.util.exception.NoSuchGroupException;
import KSA_offical_web.smallgroup.spring.util.exception.NoSuchMemberException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceLogic implements MemberService {

    MemberStore memberStore;

    public MemberServiceLogic(MemberStore memberStore) {
        this.memberStore = memberStore;
    }

    @Override
    public String registerMember(MemberCdo member) {
        String givenEmail = member.getEmail();
        CommunityMember memberFound = memberStore.retrieveByEmail(givenEmail);

        if(memberFound != null){
            throw new MemberDuplicationException("Member with email \""+ givenEmail + "\" already exsists.");
        }

        CommunityMember newMember = new CommunityMember(member.getEmail(), member.getName(), member.getPhoneNumber());
        newMember.setNickName(member.getNickName());
        newMember.setBirthDay(member.getBirthDay());

        newMember.checkValidation();

        memberStore.create(newMember);

        return newMember.getId();
    }

    @Override
    public CommunityMember findMemberById(String memberId) {
        return memberStore.retrieve(memberId);
    }

    @Override
    public CommunityMember findMemberByEmail(String memberEmail) {
        return memberStore.retrieveByEmail(memberEmail);
    }

    @Override
    public List<CommunityMember> findMembersByName(String name) {
        return memberStore.retrieveByName(name);
    }

    @Override
    public void modifyMember(String memberId, NameValueList nameValueList) {
        CommunityMember targetMember = memberStore.retrieve(memberId);
        if(targetMember == null){
            throw new NoSuchMemberException("No such member with id: " + memberId);
        }

        targetMember.modifyValues(nameValueList);

        memberStore.update(targetMember);
    }

    @Override
    public void removeMember(String memberId) {
        if(!memberStore.exists(memberId)){
            throw new NoSuchMemberException("No such member with id: " + memberId);
        }
        memberStore.delete(memberId);
    }
}
