package KSA_offical_web.smallgroup.spring.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SmallGroupCdo implements Serializable {
    //
    private String name;
    private String intro;
}
