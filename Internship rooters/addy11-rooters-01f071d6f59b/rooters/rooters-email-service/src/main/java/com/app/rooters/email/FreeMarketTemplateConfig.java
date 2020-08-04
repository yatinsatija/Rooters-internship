package com.app.rooters.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Free marker configuration.
 *
 */
@Configuration
public class FreeMarketTemplateConfig {

    @Bean
    public freemarker.template.Configuration freeMarkerConfiguration() {
        freemarker.template.Configuration config
                = new freemarker.template.Configuration(freemarker.template.Configuration.getVersion());
        config.setClassForTemplateLoading(this.getClass(), "/mail/templates/");
        return config;
    }

}
