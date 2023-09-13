package com.ufriend.user;

import com.ufriend.language.LanguageService;
import com.ufriend.role.RoleDao;
import com.ufriend.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private LanguageService languageService;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> list() {
        return (ArrayList<UserEntity>) userDao.findAll();
    }

    @Override
    public UserEntity findById(Long userId) {
        return userDao.findById(userId).orElse(null);
    }

    @Override
    public void save(UserEntity user) {
        if (user.getRole() == null)
            user.setRole(roleDao.findByName("USER"));
        if (user.getTheme() == null)
            user.setTheme(themeService.findById("01"));
        if (user.getLanguage() == null)
            user.setLanguage(languageService.findById("EN"));
        userDao.save(user);
    }

    @Override
    public void delete(UserEntity user) {
        userDao.delete(user);
    }
}
