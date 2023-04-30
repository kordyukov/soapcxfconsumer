package com.cfxconsume.job;

import com.cfxconsume.configuration.quartz.ScheduledSyncProperties;
import com.cfxconsume.entity.Product;
import com.cfxconsume.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(ScheduledSyncProperties.class)
public class ScheduledSyncJob extends QuartzJobBean {
    public static final String JOB_NAME = "SyncJob";

    private final ScheduledSyncProperties scheduledSyncProperties;
    private final ProductService productService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        if (!scheduledSyncProperties.enabled()) {
            log.warn("Scheduled synchronization quartz job is disabled");
            return;
        }

        log.info("Scheduled synchronization quartz job started");
//        var productTest = new Product();
//        productTest.setProductName("name");
//        productTest.setDescription("fghfgh");
//        productTest.setEstimation(1);
//        productTest.setPrice(10D);
//        productService.saveProduct(productTest);

        var products = productService.findAll();

        if (products.isEmpty()) {
            log.info("No product in products");
            return;
        }

        int randomNum = randInt(0, products.size() - 1);

        var product = products.get(randomNum);
        var priceBefore = product.getPrice();

        setNewPriceAndSave(priceBefore, product);

        sleepJob();

        setBeforePriceAndSave(priceBefore, product);
    }

    private void setNewPriceAndSave(Double priceBefore, Product product) {
        var percent = priceBefore / 100 * randInt(5, 10);
        var afterPrice = percent + priceBefore;
        product.setPrice(afterPrice);

        log.info("Add percent {} for  new price {} for product {} complete", percent, afterPrice, product.getId());

        productService.saveProduct(product);
    }

    private void setBeforePriceAndSave(Double priceBefore, Product product) {
        product.setPrice(priceBefore);
        productService.saveProduct(product);

        log.info("Set before price {} for product {} complete", priceBefore, product.getId());
    }

    private void sleepJob() {
        try {
            Thread.sleep(60 * 60 * 1000);
            log.info("Wait 60 min");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
