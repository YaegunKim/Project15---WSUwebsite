package KSA_offical_web.smallgroup.web.service.sdo;

import KSA_offical_web.smallgroup.web.aggregate.group.vo.RoleInGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipCdo implements Serializable {
    //
    private String groupId;
    private String memberId;
    private RoleInGroup role;
}
