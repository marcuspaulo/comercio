package br.com.comercio.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
      /*
      EXAMPLE OF AUTHENTICATION AND AUTHORIZATION
      
      http.authorizeRequests()
      .antMatchers("/url1").hasRole("ADMIN")
      .antMatchers("/url2/**").permitAll()
      .antMatchers(HttpMethod.POST,"/specificUrl").hasRole("ADMIN")
      .antMatchers("/url3/**").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin().loginPage("/login").permitAll()
      .and()
      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
       */
   }

   @Autowired
//   private UserDetailsService users;

   @Override
   protected void configure(AuthenticationManagerBuilder auth)
         throws Exception
   {
//      auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
   }

   @Override
   public void configure(WebSecurity web) throws Exception
   {
      //you can change 
//      web.ignoring().antMatchers("/resources/**").antMatchers("/webapp/**");
	   web.ignoring().antMatchers("/**");
   }
}
