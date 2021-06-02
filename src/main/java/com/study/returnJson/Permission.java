package com.study.returnJson;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/31 0031 - 05 - 31 - 23:03
 * @Description: com.study.returnJson
 * @version: 1.0
 */
public class Permission {
    private String permissionId;

    public Permission() {
    }

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
