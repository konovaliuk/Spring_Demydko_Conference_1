package one.persistence.data;

import one.persistence.entity.User;

/**
 * Used for access to data base
 */
public interface IUser {
    User findUserByEmail(String email);
    User saveUser(User user);
    User changeUsers(User oldUser, User newUser);
}

