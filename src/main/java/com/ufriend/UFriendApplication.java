package com.ufriend;

import com.ufriend.language.LanguageEntity;
import com.ufriend.language.LanguageService;
import com.ufriend.role.RoleEntity;
import com.ufriend.role.RoleService;
import com.ufriend.theme.ThemeEntity;
import com.ufriend.theme.ThemeService;
import com.ufriend.user.UserEntity;
import com.ufriend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UFriendApplication {

	@Autowired
	private RoleService roleService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UFriendApplication.class, args);
	}

	@PostConstruct
	public void loadInitialData(){
		createLanguages();
		createRoles();
		createThemes();
		createUsers();
	}

	private void createRoles(){
		RoleEntity adminRole = roleService.findById("01");
		if (adminRole == null){
			adminRole = new RoleEntity();
			adminRole.setId("01");
			adminRole.setName("ADMIN");
		}
		roleService.save(adminRole);

		RoleEntity userRole = roleService.findById("02");
		if (userRole == null){
			userRole = new RoleEntity();
			userRole.setId("02");
			userRole.setName("USER");
		}
		roleService.save(userRole);
	}

	private void createThemes(){
		ThemeEntity lightTheme = themeService.findById("01");
		if (lightTheme == null){
			lightTheme = new ThemeEntity();
			lightTheme.setId("01");
			lightTheme.setName("LIGHT");
		}
		themeService.save(lightTheme);

		ThemeEntity darkTheme = themeService.findById("02");
		if (darkTheme == null){
			darkTheme = new ThemeEntity();
			darkTheme.setId("02");
			darkTheme.setName("DARK");
		}
		themeService.save(darkTheme);
	}

	private void createLanguages(){
		LanguageEntity language = languageService.findById("EN");
		if (language == null){
			language = new LanguageEntity();
			language.setId("EN");
			language.setName("ENGLISH");
		}
		languageService.save(language);
	}

	private void createUsers(){
		UserEntity adminUser = userService.findById(1L);
		if (adminUser == null){
			adminUser = new UserEntity();
		}
		adminUser.setEmail("admin@ufriend.com");
		adminUser.setPassword("Asdf1234$");
		adminUser.setName("ADMIN");
		adminUser.setConfirmed(true);
		adminUser.setRole(roleService.findById("01"));
		adminUser.setTheme(themeService.findById("01"));
		adminUser.setLanguage(languageService.findById("EN"));
		userService.save(adminUser);
	}
}