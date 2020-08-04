package com.app.rooters;

import com.app.rooters.admin.web.AdminWebConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class,
        FreeMarkerAutoConfiguration.class})
@PropertySource("boot-defaults.properties")
@Import({AdminWebConfig.class})
public class RootersAdminWeb {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Locale.setDefault(Locale.US);
        new SpringApplicationBuilder(RootersAdminWeb.class)
                .headless(true)
                .build()
                .run(args);
    }
}
