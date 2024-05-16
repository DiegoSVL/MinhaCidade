package br.com.minhacidade.moduloweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        var joao = User.withDefaultPasswordEncoder().username("joao").password("123456").roles("USER").build();
        var maria = User.withDefaultPasswordEncoder().username("maria").password("123456").roles("USER").build();
        var gestor = User.withDefaultPasswordEncoder().username("gestor").password("123456").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(joao, maria, gestor);
    }

    /*protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .mvcMatchers("/").permitAll()
                    .mvcMatchers("/admin/**").hasRole("ADMIN")
                    .mvcMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .permitAll();
    }*/

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/resources/css/**", "/webjars/**", "/css/**").permitAll()
                        .mvcMatchers("/admin/**").hasRole("ADMIN")
                        .mvcMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated())
                        .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and()
                        .exceptionHandling()
                        .accessDeniedPage("/accessDenied")
                        .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .permitAll();
        return http.build();
    }
}