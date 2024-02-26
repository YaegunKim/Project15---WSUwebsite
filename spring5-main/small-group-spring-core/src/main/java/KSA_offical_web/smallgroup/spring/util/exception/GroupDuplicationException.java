package KSA_offical_web.smallgroup.spring.util.exception;

public class GroupDuplicationException extends RuntimeException {
	//
	private static final long serialVersionUID = -4246979292397269539L;

	public GroupDuplicationException(String message) {
		super(message); 
	}
}