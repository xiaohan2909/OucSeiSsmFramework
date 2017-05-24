package sei.pojo;

import java.util.Objects;

import org.hamcrest.core.IsInstanceOf;

public class Permission {
    private Long id;

    private String permissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }
    /**重写HasCode和equals方法方便比较*/
	@Override
	public int hashCode() {
		if(permissionName!=null&&! permissionName.trim().isEmpty())
			return Objects.hashCode(permissionName);
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Permission)
			return permissionName.equals(((Permission)obj).permissionName);		
		return super.equals(obj);
	}
    
}