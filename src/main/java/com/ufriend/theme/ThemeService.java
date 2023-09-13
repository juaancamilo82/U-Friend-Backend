package com.ufriend.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeService implements IThemeService {

    @Autowired
    private ThemeDao themeDao;

    @Override
    @Transactional(readOnly = true)
    public List<ThemeEntity> list() {
        return (ArrayList<ThemeEntity>) themeDao.findAll();
    }

    @Override
    public ThemeEntity findById(String themeId) {
        return themeDao.findById(themeId).orElse(null);
    }

    @Override
    public void save(ThemeEntity language) {
        themeDao.save(language);
    }

    @Override
    public void delete(ThemeEntity language) {
        themeDao.delete(language);
    }
}
