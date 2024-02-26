package KSA_offical_web.smallgroup.spring.service;

import KSA_offical_web.smallgroup.spring.aggregate.group.CommunityMember;
import KSA_offical_web.smallgroup.spring.service.sdo.MemberCdo;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;

import java.util.List;

public interface MemberService {
	//
	String registerMember(MemberCdo member);
	CommunityMember findMemberById(String memberId);
	CommunityMember findMemberByEmail(String memberEmail);
	List<CommunityMember> findMembersByName(String name);
	void modifyMember(String memberId, NameValueList member);
	void removeMember(String memberId);
}