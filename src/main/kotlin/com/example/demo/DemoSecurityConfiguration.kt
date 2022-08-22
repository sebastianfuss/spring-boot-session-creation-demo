package com.example.demo

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true,
)
@ConditionalOnWebApplication
@ConditionalOnProperty(
    prefix = "web.security",
    name = ["enabled"],
    havingValue = "true",
    matchIfMissing = true,
)
@Import(OAuth2ResourceServerAutoConfiguration::class)
class DemoSecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .logout().disable()
            .jee().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http {
            authorizeRequests {
                authorize(anyRequest, denyAll)
            }

            oauth2ResourceServer {
                jwt {
                    jwtAuthenticationConverter = JwtAuthenticationConverter()
                }
            }

        }
        return http.build()
    }
}

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//    prePostEnabled = true,
//    securedEnabled = true,
//    jsr250Enabled = true,
//)
//@ConditionalOnWebApplication
//@ConditionalOnProperty(
//    prefix = "web.security",
//    name = ["enabled"],
//    havingValue = "true",
//    matchIfMissing = true,
//)
//@Import(OAuth2ResourceServerAutoConfiguration::class)
//class DemoSecurityConfiguration : WebSecurityConfigurerAdapter() {
//
//    override fun configure(http: HttpSecurity) {
//        http
//            .csrf().disable()
//            .formLogin().disable()
//            .logout().disable()
//            .jee().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//        http {
//            authorizeRequests {
//                authorize(anyRequest, denyAll)
//            }
//            oauth2ResourceServer {
//                jwt {
//                    jwtAuthenticationConverter = JwtAuthenticationConverter()
//                }
//            }
//        }
//    }
//}

