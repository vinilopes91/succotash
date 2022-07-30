package br.ufu.succotash.controller.user.request;

import br.ufu.succotash.domain.enumeration.Role;
import br.ufu.succotash.domain.model.User;

public record UserUpdateRequest(
        String fullName,
        String password,
        Role role
) {

    public User updateModel(User user) {
        user.setRole(role);
        user.setFullName(fullName);
        user.setPassword(password);
        return user;
    }
}
