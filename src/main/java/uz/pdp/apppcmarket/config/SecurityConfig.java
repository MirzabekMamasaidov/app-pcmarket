package uz.pdp.apppcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("SUPER_ADMIN")
                .authorities("READ","READ_ALL","ADD","EDIT","DELETE")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator"))
                .roles("MODERATOR").authorities("ADD","EDIT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/order/**").hasAnyRole("OPERATOR","SUPER_ADMIN")
                .antMatchers(HttpMethod.POST,"/api/product/*").hasAnyRole("MODERATOR","SUPER_ADMIN")
                .antMatchers(HttpMethod.PUT,"/spi/product/**").hasAnyRole("MODERATOR","SUPER_ADMIN")
                .antMatchers("/api/brand/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/category/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/currency/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/user/**").hasRole("SUPER_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
