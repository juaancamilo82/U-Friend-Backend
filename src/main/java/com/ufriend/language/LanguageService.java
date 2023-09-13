package com.ufriend.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService implements ILanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Override
    @Transactional(readOnly = true)
    public List<LanguageEntity> list() {
        return (ArrayList<LanguageEntity>) languageDao.findAll();
    }

    @Override
    public LanguageEntity findById(String languageId) {
        return languageDao.findById(languageId).orElse(null);
    }

    @Override
    public void save(LanguageEntity language) {
        languageDao.save(language);
    }

    @Override
    public void delete(LanguageEntity language) {
        languageDao.delete(language);
    }
}
