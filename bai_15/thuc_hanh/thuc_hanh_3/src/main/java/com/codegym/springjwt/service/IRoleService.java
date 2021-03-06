package com.codegym.springjwt.service;

import com.codegym.springjwt.model.Role;
import com.codegym.springjwt.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}

