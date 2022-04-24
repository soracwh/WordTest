package entity.tans;


import lombok.Data;

/**
 * @Author Sora Chen
 * @Date 2022/4/11 13:20
 * @Version 1.0
 */

@Data
public class OtherProtect {
    //过负荷
    private String OverLoadCurrent;
    private String OverLoadTime;

    //间隙零流
    private String HighGapZeroTime;
    private String HighGapZeroCurrent;

    private String MiddleGapZeroTime;
    private String MiddleGapZeroCurrent;

    //零序电压保护
    private String ZeroVoltage;
    private String ZeroVoltageTime;


}
