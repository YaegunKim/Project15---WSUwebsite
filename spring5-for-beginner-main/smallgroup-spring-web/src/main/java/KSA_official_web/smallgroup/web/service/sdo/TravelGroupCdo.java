package KSA_offical_web.smallgroup.web.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelGroupCdo implements Serializable {
    //
    private String name;
    private String intro;
}
