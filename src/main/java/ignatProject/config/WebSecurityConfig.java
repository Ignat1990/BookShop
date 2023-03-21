
package ignatProject.config;



import ignatProject.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceimpl;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/home", "/index", "/about", "/help", "/registration").permitAll()
                .antMatchers("/user/**", "/templates/user/**", "/cart/**", "/searchByBookGanre/**").hasRole("USER")
                .antMatchers("/**", "/carttoorder/**", "/user/orders" ).hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceimpl).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/webjars/**", "/js/**", "/error/**"
                , "/css/**", "/fonts/**", "/libs/**", "/images/**");
    }


}
