package playlist;

import java.io.Serializable;

public class Artist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	public Artist() {}

	public Artist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
