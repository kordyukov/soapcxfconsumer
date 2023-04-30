package com.cfxconsume.configuration.quartz;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties(prefix = "spring.quartz.jobs.scheduled-sync")
@Validated
public record ScheduledSyncProperties(
    @NotNull
    Boolean enabled,

    @NotNull
    Duration interval
) {
}
