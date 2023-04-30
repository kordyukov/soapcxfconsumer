package com.cfxconsume.configuration.quartz;

import com.cfxconsume.job.ScheduledSyncJob;
import lombok.AllArgsConstructor;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import static org.quartz.SimpleTrigger.REPEAT_INDEFINITELY;

@Configuration
@EnableConfigurationProperties({ScheduledSyncProperties.class})
@AllArgsConstructor
@Profile("!test")
public class QuartzConfiguration {
    private ScheduledSyncProperties scheduledSyncProperties;

    @Bean(name = ScheduledSyncJob.JOB_NAME)
    public JobDetailFactoryBean loopSyncJob() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(ScheduledSyncJob.class);
        jobDetailFactoryBean.setDescription("Sync sync scheduled loops");
        jobDetailFactoryBean.setName(ScheduledSyncJob.JOB_NAME);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean loopSyncTrigger(@Qualifier(ScheduledSyncJob.JOB_NAME) JobDetail jobDetail) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(jobDetail);
        trigger.setRepeatInterval(scheduledSyncProperties.interval().toMillis());
        trigger.setRepeatCount(REPEAT_INDEFINITELY);
        return trigger;
    }
}
