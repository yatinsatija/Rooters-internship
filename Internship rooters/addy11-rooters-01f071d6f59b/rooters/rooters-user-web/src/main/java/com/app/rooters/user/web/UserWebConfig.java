package com.app.rooters.user.web;

import com.app.rooters.common.web.CommonWebConfig;
import com.app.rooters.db.DbPersistConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Slf4j
@Import({DbPersistConfig.class})
public class UserWebConfig extends CommonWebConfig {

}
