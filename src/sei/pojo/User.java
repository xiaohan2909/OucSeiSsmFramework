package sei.pojo;

import java.util.List;
import java.util.Set;

public class User {
    private Long id;

    private String username;

    private String password;
    /**用户所拥有的权限*/
    private Set<Permission> permSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public Set<Permission> getPermSet() {
		return permSet;
	}

	public void setPermSet(Set<Permission> permlist) {
		this.permSet = permlist;
	}
    
    
}