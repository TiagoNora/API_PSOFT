package com.psoft.project.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Value("${springdoc.api-docs.path}")
    private String restApiDocPath;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;


    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/api-docs/**").permitAll()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/h2-ui/**").permitAll()
                .antMatchers("/products/**").permitAll()
                .antMatchers(HttpMethod.POST,"/reviews/**").hasAnyAuthority("COSTUMER","MODERATOR")
                .antMatchers(HttpMethod.GET,"/reviews/**").permitAll()
                .antMatchers(HttpMethod.POST,"/votes/**").hasAnyAuthority("COSTUMER","MODERATOR")
                .antMatchers(HttpMethod.DELETE,"/reviews/**").hasAnyAuthority("COSTUMER","MODERATOR")
                .antMatchers(HttpMethod.GET,"/votes/**").permitAll()
                .antMatchers(HttpMethod.GET,"/moderator/reviews/**").hasAuthority("MODERATOR")
                .antMatchers(HttpMethod.GET,"/reviews/user/**").hasAnyAuthority("COSTUMER","MODERATOR")
                .antMatchers("/products/**/rating").permitAll()
                .antMatchers(HttpMethod.POST,"/images/uploadFile/**").hasAuthority("MODERATOR")
                .antMatchers(HttpMethod.GET,"/images/**").permitAll()
                .anyRequest().authenticated();
        http.headers().frameOptions().disable();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}

