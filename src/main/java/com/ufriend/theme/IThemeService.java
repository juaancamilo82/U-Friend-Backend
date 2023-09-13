package com.ufriend.theme;

import java.util.List;

public interface IThemeService {
    public List<ThemeEntity> list();
    public ThemeEntity findById(String themeId);
    public void save(ThemeEntity language);
    public void delete(ThemeEntity language);
}
