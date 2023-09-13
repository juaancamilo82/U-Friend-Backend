package com.ufriend.language;

import java.util.List;

public interface ILanguageService {
    public List<LanguageEntity> list();
    public LanguageEntity findById(String languageId);
    public void save(LanguageEntity language);
    public void delete(LanguageEntity language);
}
