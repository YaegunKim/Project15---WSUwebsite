package KSA_offical_web.smallgroup.spring.aggregate.group;

import KSA_offical_web.smallgroup.spring.aggregate.Entity;
import KSA_offical_web.smallgroup.spring.shared.NameValue;
import KSA_offical_web.smallgroup.spring.shared.NameValueList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmallGroup extends Entity {
	//
	private static final int MINIMUM_NAME_LENGTH =  3;
	private static final int MINIMUM_INTRO_LENGTH =  10;

	private String name;
	private String intro;
	private long foundationTime;

	public SmallGroup(String id) {
		//
		super(id);
	}

	public SmallGroup(String name, String intro) {
		//
		super();
		this.name = name;
		this.intro = intro;
		this.foundationTime = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		//
		StringBuilder builder = new StringBuilder();

		builder.append("Small Group Id:").append(id);
		builder.append(", name:").append(name);
		builder.append(", intro:").append(intro);
		builder.append(", foundation day:").append(foundationTime);

		return builder.toString();
	}

	public void checkValidation() {
		//
		checkNameValidation(name);
		checkIntroValidation(intro);
	}

	private void checkNameValidation(String name) {
		//
		if (name.length() < SmallGroup.MINIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("\t > Name should be longer than " + SmallGroup.MINIMUM_NAME_LENGTH);
		}
	}

	private void checkIntroValidation(String intro) {
		//
		if (intro.length() < SmallGroup.MINIMUM_INTRO_LENGTH) {
			throw new IllegalArgumentException("\t > Intro should be longer than " + SmallGroup.MINIMUM_INTRO_LENGTH);
		}
	}

	public void modifyValues(NameValueList nameValues) {
		//
		for (NameValue nameValue : nameValues.getNameValues()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "name":
					checkNameValidation(value);
					this.name = value;
					break;
				case "intro":
					checkIntroValidation(value);
					this.intro = value;
					break;
			}
		}
	}

	public static SmallGroup sample() {
		//
		String name = "JavaSmallGroup";
		String intro = "Small group to the Java island.";

		return new SmallGroup(name, intro);
	}

	public static void main(String[] args) {
		//
		System.out.println(sample().toString());
	}
}
