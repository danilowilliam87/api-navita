package com.navita.test.desafioApiNavita.config;

import com.navita.test.desafioApiNavita.service.implementacao.JwtAuthFilter;
import com.navita.test.desafioApiNavita.service.implementacao.JwtService;
import com.navita.test.desafioApiNavita.service.implementacao.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserImplService userImplService;

    @Autowired
    private JwtService jwtService;

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }

    @Bean
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, userImplService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userImplService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/usuario/delete/**")
                .hasRole("USER")
                .antMatchers("/patrimonio/**")
                .hasRole("USER")
                .antMatchers("/marca/**")
                .hasRole("USER")
                .antMatchers("/usuario/salvar/**")
                .permitAll()
                .antMatchers("/usuario/atualizar/**")
                .hasRole("USER")
                .antMatchers("/usuario/lista")
                .hasRole("USER")
                .antMatchers("/usuario/email/**")
                .hasRole("USER")
                .antMatchers("/usuario/nome/**")
                .hasRole("USER")
                .antMatchers("/usuario/buscar/**")
                .hasRole("USER")
                .anyRequest().authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);


    }
}
