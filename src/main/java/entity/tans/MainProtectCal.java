package entity.tans;

import lombok.Data;

/**
 * @Author Sora Chen
 * @Date 2022/4/12 21:19
 * @Version 1.0
 */

@Data
public class MainProtectCal {
    //折算值
    private String EHCurrent;
    private String EMCurrent;
    private String ELCurrent;

    private String Id1;
    private String Id2;
    private String basicHighCurrent1;
    private String basicLowCurrent1;
    private String basicHighCurrent2;
    private String basicLowCurrent2;

    private String trueHighCurrent1;
    private String trueLowCurrent1;
    private String trueHighCurrent2;
    private String trueLowCurrent2;

    private String k;
}
