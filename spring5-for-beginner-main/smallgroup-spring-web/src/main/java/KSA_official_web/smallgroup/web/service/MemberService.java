package KSA_offical_web.smallgroup.web.service;

import KSA_offical_web.smallgroup.web.aggregate.club.CommunityMember;
import KSA_offical_web.smallgroup.web.service.sdo.MemberCdo;
import KSA_offical_web.smallgroup.web.shared.NameValueList;

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