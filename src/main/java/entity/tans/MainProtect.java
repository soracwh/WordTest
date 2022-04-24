package entity.tans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Sora Chen
 * @Date 2022/4/10 14:36
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainProtect {
    //变压器参数
    private String HighCapacity;
    private String MiddleCapacity;
    private String LowCapacity;
    private String HighVoltage;
    private String MiddleVoltage;
    private String LowVoltage;
    private String HighRation;
    private String MiddleRation;
    private String LowRation;
    private String HighCurrent;
    private String MiddleCurrent;
    private String LowCurrent;


    //差动保护
    private String differentialCurrent;
    private String differentialFastCurrent;
    private String harmonic;
    private String differentialWarning;
    private String differentialWarningTime;

}
