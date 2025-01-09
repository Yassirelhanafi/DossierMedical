package emi.spring.dossiermedical.security;


import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager users() {
        UserDetails agentMedical = User.withDefaultPasswordEncoder()  //medecin ou infermier
                .username("medecin")
                .password("medecin-pass")
                .roles("medecin")
                .build();

        UserDetails agentFacturation = User.withDefaultPasswordEncoder()
                .username("caissier")
                .password("caissier_pass")
                .roles("agentFacturation")
                .build();


        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin-pass")
                .roles("admin","client")
                .build();

        return new InMemoryUserDetailsManager(agentMedical,agentFacturation,admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.dispatcherTypeMatchers(DispatcherType.REQUEST).permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers(HttpMethod.GET, "/patient/**").permitAll()
                                .requestMatchers("/patient/**").hasRole("agentMedical")
                                .requestMatchers("/fichePayment/**").hasRole("agentFacturation")
                                .requestMatchers("/DossierMedical/**").hasRole("agentMedical")
                                .requestMatchers("/prescription/**").hasRole("agentMedical")
                                .requestMatchers("/consultation/**").hasRole("agentMedical")
                                .requestMatchers("/operationAnalyse/**").hasRole("agentMedical")
                                .requestMatchers("/ficheConsultation/**").hasRole("agentMedical")
                                .requestMatchers("/**").hasRole("admin")

                        ).httpBasic(Customizer.withDefaults());
        return http.build();


    }
}
