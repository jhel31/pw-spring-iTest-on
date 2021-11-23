package pe.edu.upc.iTeston.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.edu.upc.iTeston.auth.handler.LoginSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}

	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEnconder());

		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/inicio-estudiante/**").access("hasRole('ROLE_STUDENT')")
		.antMatchers("/perfil-estudiante/**").access("hasRole('ROLE_STUDENT')")
		.antMatchers("/careers/simulacro/**").access("hasRole('ROLE_STUDENT')")
		.antMatchers("/quizzes/misnotas/**").access("hasRole('ROLE_STUDENT')")
		.antMatchers("/premium/**").access("hasRole('ROLE_STUDENT')")
		.antMatchers("/inicio-docente/**").access("hasRole('ROLE_TEACHER')")
		.antMatchers("/perfil-docente/**").access("hasRole('ROLE_TEACHER')")
		.antMatchers("/saldo/**").access("hasRole('ROLE_TEACHER')")
		.antMatchers("/mis-balotarios/**").access("hasRole('ROLE_TEACHER')")
		.antMatchers("/nuevo-balotario/**").access("hasRole('ROLE_TEACHER')")
		.antMatchers("/logout").permitAll()
		
				.and().formLogin().successHandler(loginSuccessHandler).loginPage("/login").loginProcessingUrl("/signin")
				.defaultSuccessUrl("/inicio").permitAll().and().logout().logoutSuccessUrl("/login")
				.permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
	}

}
