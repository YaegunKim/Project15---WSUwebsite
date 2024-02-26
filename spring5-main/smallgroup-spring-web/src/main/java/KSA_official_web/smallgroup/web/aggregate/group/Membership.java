package KSA_offical_web.smallgroup.web.aggregate.group;

import KSA_offical_web.smallgroup.web.aggregate.Entity;
import KSA_offical_web.smallgroup.web.aggregate.group.vo.RoleInGroup;
import KSA_offical_web.smallgroup.web.shared.NameValue;
import KSA_offical_web.smallgroup.web.shared.NameValueList;
import KSA_offical_web.smallgroup.web.util.helper.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Membership extends Entity {
	//
	private String groupId;
	private String memberId;
	private RoleInGroup role;
	private String joinDate;

	public Membership(String id) {
		//
		super(id);
	}

	public Membership(String groupId, String memberId) {
		//
		this.groupId = groupId;
		this.memberId = memberId;
		this.role = RoleInGroup.Member;
		this.joinDate = DateUtil.today();
	}

	@Override
	public String toString() {
		//
		StringBuilder builder = new StringBuilder();

		builder.append("group Id:").append(groupId);
		builder.append(", member Id:").append(memberId);
		builder.append(", role:").append(role.name());
		builder.append(", join date:").append(joinDate);

		return builder.toString();
	}

	public void modifyValues(NameValueList nameValueList) {
		//
		for (NameValue nameValue : nameValueList.getNameValues()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "role":
					this.role = RoleInGroup.valueOf(value);
					break;
			}
		}
	}

	public static Membership sample() {
		//
		return new Membership(
				SmallGroup.sample().getId(),
				CommunityMember.sample().getId()
		);
	}

	public static void main(String[] args) {
		// 
		System.out.println(sample().toString());
	}
}