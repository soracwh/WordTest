package util.Trans;

import entity.tans.MainProtect;
import entity.tans.MainProtectCal;

import java.util.Random;

/**
 * @Author Sora Chen
 * @Date 2022/4/12 21:42
 * @Version 1.0
 */
public class CalUtil {
    public static void getDifferPoint(String factory, MainProtect mainProtect, MainProtectCal mainProtectCal ){
        Random random = new Random();
        double k = 0.5+((0.5-random.nextDouble())/100);
        double firstIr = 2.0;
        double secondIr = 4.0;
        double Icd = Double.parseDouble(mainProtect.getDifferentialCurrent());
        mainProtectCal.setK(String.format("%.3f",k));
        double firstId;
        double secondId;
        //计算两个点的值
        if(factory.indexOf('四') != -1){
            firstId = k*(firstIr-0.6)+0.12+Icd;
            secondId = k*(secondIr-0.6)+0.12+Icd;
        }else{
            if(factory.indexOf('国') != -1){
                firstId = k*(firstIr-0.8)+Icd;
                secondId = k*(secondIr-0.8)+Icd;
            }else{
                firstId = k*(firstIr-0.5)+0.1+Icd;
                secondId = k*(secondIr-0.5)+0.1+Icd;
            }
        }
        mainProtectCal.setId1(String.format("%.2f",firstId));
        mainProtectCal.setId2(String.format("%.2f",secondId));
        //计算高压侧低压侧
        double firstHigh = (2*firstIr+firstId)/2;
        double firstLow = (2*firstIr-firstId)/2;
        double secondHigh = (2*secondIr+secondId)/2;
        double secondLow = (2*secondIr-secondId)/2;

        mainProtectCal.setBasicHighCurrent1(String.format("%.3f",firstHigh));
        mainProtectCal.setBasicLowCurrent1(String.format("%.3f",firstLow));
        mainProtectCal.setBasicHighCurrent2(String.format("%.3f",secondHigh));
        mainProtectCal.setBasicLowCurrent2(String.format("%.3f",secondLow));

        double Ih = Double.parseDouble(mainProtect.getHighCapacity())*Double.parseDouble(mainProtect.getHighCurrent())*1000/
                ((Double.parseDouble(mainProtect.getHighRation())*Double.parseDouble(mainProtect.getHighVoltage())*Math.sqrt(3.0)));
        double Im = Double.parseDouble(mainProtect.getMiddleCapacity())*Double.parseDouble(mainProtect.getMiddleCurrent())*1000/
                ((Double.parseDouble(mainProtect.getMiddleRation())*Double.parseDouble(mainProtect.getMiddleVoltage())*Math.sqrt(3.0)));
        double Il = Double.parseDouble(mainProtect.getLowCapacity())*Double.parseDouble(mainProtect.getLowCurrent())*1000/
                ((Double.parseDouble(mainProtect.getLowRation())*Double.parseDouble(mainProtect.getLowVoltage())*Math.sqrt(3.0)));
        mainProtectCal.setEHCurrent(String.format("%.3f",Ih));
        mainProtectCal.setEMCurrent(String.format("%.3f",Im));
        mainProtectCal.setELCurrent(String.format("%.3f",Il));

        mainProtectCal.setTrueHighCurrent1(String.format("%.3f",firstHigh*Ih));
        mainProtectCal.setTrueLowCurrent1(String.format("%.3f",firstLow*Il));
        mainProtectCal.setTrueHighCurrent2(String.format("%.3f",secondHigh*Ih));
        mainProtectCal.setTrueLowCurrent2(String.format("%.3f",secondLow*Il));
    }
}
