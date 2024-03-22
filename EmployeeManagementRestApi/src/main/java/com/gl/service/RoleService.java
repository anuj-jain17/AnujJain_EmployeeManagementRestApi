package com.gl.service;

import com.gl.model.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(int id);
    Role addRole(Role role);
    void deleteRole(int id);
}
