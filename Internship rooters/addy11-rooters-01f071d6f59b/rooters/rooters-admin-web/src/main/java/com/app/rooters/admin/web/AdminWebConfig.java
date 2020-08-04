package com.app.rooters.admin.web;

import com.app.rooters.common.web.CommonWebConfig;
import com.app.rooters.db.DbPersistConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Admin web config.
 *
 * @author aadgupta
 */
@Configuration
@ComponentScan
@Slf4j
@Import({DbPersistConfig.class})
public class AdminWebConfig extends CommonWebConfig {

}
