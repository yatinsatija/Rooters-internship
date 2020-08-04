package com.app.rooters;

import com.app.rooters.user.web.UserWebConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootConfiguration
@PropertySource("boot-defaults.properties")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        FlywayAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, FreeMarkerAutoConfiguration.class})
@Import({UserWebConfig.class})
@Profile("!nosecurity")
@EnableCaching
public class RootersUserWeb {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Locale.setDefault(Locale.US);
        new SpringApplicationBuilder(RootersUserWeb.class)
                .headless(true)
                .build()
                .run(args);
    }
}
