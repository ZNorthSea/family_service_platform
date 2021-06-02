package com.study.returnJson;

import java.util.List;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/31 0031 - 05 - 31 - 23:04
 * @Description: com.study.returnJson
 * @version: 1.0
 */
public class Permissions {
    private List<Permission> permissions;

    public Permissions() {
    }

    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
