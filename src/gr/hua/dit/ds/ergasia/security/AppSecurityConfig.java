package gr.hua.dit.ds.ergasia.security;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter  {
	  
	  @Autowired
	  private DataSource dataSource;

	   @Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	           auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
	           .usersByUsernameQuery("select username,password, enabled from user where username=?")
	           .authoritiesByUsernameQuery("select username, authority from authorities where username=?");

	           System.out.println("Done...finito");
	   }
	
	  @Override
	   public void configure(WebSecurity web) throws Exception {
	           web.ignoring().antMatchers("/resources/**");

	           web.ignoring().antMatchers("/api/**");

	   }
	  
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/signup").permitAll()
			.antMatchers("/").hasAnyRole("EMPLOYEE","HEAD","DIRECTOR","PERSONEL","ADMIN")
			.antMatchers("/menu").hasAnyRole("EMPLOYEE","HEAD","ADMIN")
			.antMatchers("/conclusion").hasAnyRole("HEAD","DIRECTOR","ADMIN")
			.antMatchers("/conclusion/personel").hasAnyRole("PERSONEL","ADMIN")
			.antMatchers("/users").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login")
			.loginProcessingUrl("/authUser").permitAll().and()
			.logout().permitAll().and().exceptionHandling()
			.accessDeniedPage("/403");

		}	

	  
	  
	  @Bean
	   public PasswordEncoder passwordEncoder() {
	           PasswordEncoder encoder = new BCryptPasswordEncoder();
	           return encoder;
	   }
}