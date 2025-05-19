package io.hhplus.tdd;

import io.hhplus.tdd.point.PointService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class CountDownLatchTest {

    private final long id = 136;

    @Autowired
    private PointService pointService;

    @DisplayName("비동기 테스트")
    @Test
    public void countDownLatchTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            pointService.charge(id,10000);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            pointService.use(id, 7000);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        pointService.charge(id,8000);

        pointService.use(id, 5000);







    }
}
