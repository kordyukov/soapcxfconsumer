package com.cfxconsume.job;

import com.cfxconsume.configuration.quartz.ScheduledSyncProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(ScheduledSyncProperties.class)
public class ScheduledSyncJob extends QuartzJobBean {
    public static final String JOB_NAME = "SyncJob";

    private final ScheduledSyncProperties scheduledSyncProperties;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        if (!scheduledSyncProperties.enabled()) {
            log.warn("Scheduled synchronization quartz job is disabled");
            return;
        }

        log.info("Scheduled synchronization quartz job started");

    }
}
