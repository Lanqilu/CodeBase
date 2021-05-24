package top.whl.pojo2;

/**
 * @author Halo
 * @date Created in 2020/07/31  13:21
 * @description 构造器注入和setter注入
 */
public class Role {
    private Long id;
    private String roleName;
    private String note;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Role(String roleName, String note) {
        this.roleName = roleName;
        this.note = note;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
