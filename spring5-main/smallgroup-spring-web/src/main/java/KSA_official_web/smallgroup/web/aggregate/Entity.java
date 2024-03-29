package KSA_offical_web.smallgroup.web.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Entity {
	//
	protected String id;

	protected Entity() {
		//
		this.id = UUID.randomUUID().toString();
	}

	protected Entity(String id) {
		//
		this.id = id;
	}
}
