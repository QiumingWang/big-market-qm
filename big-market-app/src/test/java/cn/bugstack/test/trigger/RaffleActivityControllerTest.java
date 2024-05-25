package cn.bugstack.test.trigger;

import cn.bugstack.trigger.api.IRaffleActivityService;
import cn.bugstack.trigger.api.dto.ActivityDrawRequestDTO;
import cn.bugstack.trigger.api.dto.ActivityDrawResponseDTO;
import cn.bugstack.trigger.api.dto.UserActivityAccountRequestDTO;
import cn.bugstack.trigger.api.dto.UserActivityAccountResponseDTO;
import cn.bugstack.types.model.Response;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @className: RaflleActivityControllerTest
 * @description: 装配测试
 * @author: qiuming
 * @date: 2024/5/21 22:35
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {
    @Resource
    private IRaffleActivityService raffleStrategyService;

    @Test
    public void test_armory(){
        Response<Boolean> response = raffleStrategyService.armory(100301L);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_draw() {
        ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
        request.setUserId("qiuming");
        request.setActivityId(100301L);
        Response<ActivityDrawResponseDTO> response = raffleStrategyService.draw(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }
    
    @Test
    public void test_calendarSignRebate() {
        Response<Boolean> response = raffleStrategyService.calendarSignRebate("qiuming");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_isCalendarSignRebate() {
        Response<Boolean> response = raffleStrategyService.isCalendarSignRebate("qiuming");
        log.info("测试结果: {}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryUserActivityAccount() {
        UserActivityAccountRequestDTO requestDTO = new UserActivityAccountRequestDTO();
            requestDTO.setUserId("xiaofuge1");
        requestDTO.setActivityId(100301L);

        // 查询数据
        Response<UserActivityAccountResponseDTO> response = raffleStrategyService.queryUserActivityAccount(requestDTO);

        log.info("请求参数：{}", JSON.toJSONString(requestDTO));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }
}
