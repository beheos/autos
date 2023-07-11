package mx.beheos.autos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	
	 	@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       /* auth.jdbcAuthentication().dataSource(dataSource)
	            .usersByUsernameQuery("SELECT username, password, enabled FROM usuarios WHERE username = ?")
	            //.authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username = ?")
	            .authoritiesByUsernameQuery("SELECT username, rol FROM roles WHERE username = ?")
	            .rolePrefix("ROLE_");*/
	 		auth.jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery("SELECT username, password, enabled FROM usuarios WHERE username = ?")
	        .authoritiesByUsernameQuery("SELECT username, rol FROM roles WHERE username = ?")
	        .rolePrefix("ROLE_")
	        .passwordEncoder(customPasswordEncoder());
	        
	    }
	
	 	@Override
	    protected void configure(HttpSecurity http) throws Exception {
		 	http.cors().and().csrf().disable(); //se desahabilita dado que no se usuaran cookies
	        http.authorizeRequests()
	            .antMatchers("/vehiculo/*", "/ventas/*").hasAnyRole("ADMIN","VENTAS")
	            .antMatchers("/empleados/*").hasAnyRole("ADMIN","RH")
	            .antMatchers("/usuarios/*", "/graficas/*").hasRole("ADMIN")
	            .antMatchers("/home").permitAll()
	            .anyRequest().permitAll()
	            .and()
	            .formLogin()
	            .loginPage("/")
	            .defaultSuccessUrl("/home/", true)
	            .failureUrl("/?error")
	            .permitAll()
	            .and()
	            .logout()
	            .logoutSuccessUrl("/")
	            .permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/errores/eccesoDenegado");
	    }
	 
	 	@Bean
	 	public PasswordEncoder customPasswordEncoder() {
	 	    return new CustomPasswordEncoder();
	 	}
	 
	 	/*@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }*/
}
