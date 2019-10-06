package one.persistence.data.impl;

import one.persistence.data.IUser;
import one.persistence.entity.User;
import one.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserImpl implements IUser {
    @Autowired
    UserRepository userRepo;

    @Transactional(readOnly = true)
    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User changeUsers(User oldUser, User newUser) {
        userRepo.delete(oldUser);
        return userRepo.save(newUser);
    }


}
