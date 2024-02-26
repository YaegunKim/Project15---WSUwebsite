package KSA_offical_web.smallgroup.spring.service.sdo;

import KSA_offical_web.smallgroup.spring.aggregate.group.vo.RoleInGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipCdo {
    //
    private String groupId;
    private String memberId;
    private RoleInGroup role;
}
