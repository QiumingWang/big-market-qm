package cn.bugstack.test.trigger;

import cn.bugstack.trigger.api.IRaffleStrategyService;
import cn.bugstack.trigger.api.dto.RaffleAwardListRequestDTO;
import cn.bugstack.trigger.api.dto.RaffleAwardListResponseDTO;
import cn.bugstack.trigger.api.dto.RaffleStrategyRuleWeightRequestDTO;
import cn.bugstack.trigger.api.dto.RaffleStrategyRuleWeightResponseDTO;
import cn.bugstack.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @className: RaffleStrategyController
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/21 18:31
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyControllerTest {

    @Resource
    private IRaffleStrategyService raffleStrategyService;

    @Test
    public void test_queryRaffleAwardList() throws InterruptedException {
        RaffleAwardListRequestDTO request = new RaffleAwardListRequestDTO();
        request.setUserId("qiuming");
        request.setActivityId(100301L);

        Response<List<RaffleAwardListResponseDTO>> response = raffleStrategyService.queryRaffleAwardList(request);

        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("测试结果: {}", JSON.toJSONString(response));

        new CountDownLatch(1).await();
    }

    @Test
    public void test_queryRaffleStrategyRuleWeight() {
        RaffleStrategyRuleWeightRequestDTO requestDTO = new RaffleStrategyRuleWeightRequestDTO();
        requestDTO.setUserId("xiaofuge");
        requestDTO.setActivityId(100301L);

        Response<List<RaffleStrategyRuleWeightResponseDTO>> responseDTO = raffleStrategyService.queryRaffleStrategyRuleWeight(requestDTO);
        log.info("请求参数：{}", JSON.toJSONString(requestDTO));
        log.info("测试结果：{}", JSON.toJSONString(responseDTO));
    }
}
