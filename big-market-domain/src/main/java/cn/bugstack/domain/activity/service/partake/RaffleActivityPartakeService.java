package cn.bugstack.domain.activity.service.partake;

import cn.bugstack.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import cn.bugstack.domain.activity.model.entity.*;
import cn.bugstack.domain.activity.model.valobj.UserRaffleOrderStateVO;
import cn.bugstack.domain.activity.repository.IActivityRepository;
import cn.bugstack.types.enums.ResponseCode;
import cn.bugstack.types.exception.AppException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className: RaffleActivityPartakeService
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/18 22:00
 */
@Service
public class RaffleActivityPartakeService  extends AbstractRaffleActivityPartake {

    private final SimpleDateFormat dateFormatMonth = new SimpleDateFormat("yyyy-MM");
    private final SimpleDateFormat dateFormatDay = new SimpleDateFormat("yyyy-MM-dd");


    protected RaffleActivityPartakeService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

    @Override
    protected CreatePartakeOrderAggregate doFilterAccount(String userId, Long activityId, Date currentDate) {
        // 查询账户总额度
        ActivityAccountEntity activityAccountEntity = activityRepository.queryRaffleActivityAccountByUserId(userId, activityId);

        // 额度判断（仅判断总剩余额度）
        if (null == activityAccountEntity || activityAccountEntity.getTotalCountSurplus() <= 0) {
            throw new AppException(ResponseCode.ACTIVITY_DATE_ERROR.getCode(), ResponseCode.ACCOUNT_QUOTA_ERROR.getInfo());
        }

        String month = dateFormatMonth.format(currentDate);
        String day = dateFormatDay.format(currentDate);

        // 查询月账户额度
        ActivityAccountMonthEntity activityAccountMonthEntity = activityRepository.queryRaffleActivityAccountMonthByUserId(userId, activityId, month);
        boolean isExistAccountMonth = null != activityAccountMonthEntity;
        if (isExistAccountMonth && activityAccountMonthEntity.getMonthCountSurplus() <= 0) {
            throw new AppException(ResponseCode.ACCOUNT_QUOTA_MONTH_ERROR.getCode(), ResponseCode.ACCOUNT_QUOTA_MONTH_ERROR.getInfo());
        }

        // 创建月账户额度
        if (!isExistAccountMonth) {
            activityAccountMonthEntity = new ActivityAccountMonthEntity();
            activityAccountMonthEntity.setUserId(userId);
            activityAccountMonthEntity.setActivityId(activityId);
            activityAccountMonthEntity.setMonth(month);
            activityAccountMonthEntity.setMonthCount(activityAccountEntity.getMonthCount());
            activityAccountMonthEntity.setMonthCountSurplus(activityAccountEntity.getMonthCountSurplus());
        }

        // 查询日账户额度
        ActivityAccountDayEntity activityAccountDayEntity = activityRepository.queryRaffleActivityAccountDayByUserId(userId, activityId, day);
        boolean isExistAccountDay = null != activityAccountDayEntity;
        if (isExistAccountDay && activityAccountDayEntity.getDayCountSurplus() <= 0) {
            throw new AppException(ResponseCode.ACCOUNT_QUOTA_DAY_ERROR.getCode(), ResponseCode.ACCOUNT_QUOTA_DAY_ERROR.getInfo());
        }

        // 创建日账户
        if (!isExistAccountDay) {
            activityAccountDayEntity = new ActivityAccountDayEntity();
            activityAccountDayEntity.setUserId(userId);
            activityAccountDayEntity.setActivityId(activityId);
            activityAccountDayEntity.setDay(day);
            activityAccountDayEntity.setDayCount(activityAccountEntity.getDayCount());
            activityAccountDayEntity.setDayCountSurplus(activityAccountEntity.getDayCountSurplus());
        }

        // 构建对象
        CreatePartakeOrderAggregate createPartakeOrderAggregate = new CreatePartakeOrderAggregate();
        createPartakeOrderAggregate.setUserId(userId);
        createPartakeOrderAggregate.setActivityId(activityId);
        createPartakeOrderAggregate.setActivityAccountEntity(activityAccountEntity);
        createPartakeOrderAggregate.setExistAccountMonth(isExistAccountMonth);
        createPartakeOrderAggregate.setActivityAccountMonthEntity(activityAccountMonthEntity);
        createPartakeOrderAggregate.setExistAccountDay(isExistAccountDay);
        createPartakeOrderAggregate.setActivityAccountDayEntity(activityAccountDayEntity);

        return createPartakeOrderAggregate;
    }

    @Override
    protected UserRaffleOrderEntity buildUserRaffleOrder(String userId, Long activityId, Date currentDate) {
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(activityId);
        // 构建订单
        UserRaffleOrderEntity userRaffleOrderEntity = new UserRaffleOrderEntity();
        userRaffleOrderEntity.setUserId(userId);
        userRaffleOrderEntity.setActivityId(activityId);
        userRaffleOrderEntity.setActivityName(activityEntity.getActivityName());
        userRaffleOrderEntity.setStrategyId(activityEntity.getStrategyId());
        userRaffleOrderEntity.setOrderId(RandomStringUtils.randomNumeric(12));
        userRaffleOrderEntity.setOrderTime(currentDate);
        userRaffleOrderEntity.setOrderState(UserRaffleOrderStateVO.create);

        return userRaffleOrderEntity;
    }


}
