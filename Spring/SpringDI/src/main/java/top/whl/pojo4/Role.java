package top.whl.pojo4;

/**
 * @author Halo
 * @date Created in 2020/07/31  15:00
 * @description 复杂装配集合
 */
public class Role {
    private Long id;
    private String roleName;
    private String note;

    public Role() {
    }

    public Role(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
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
