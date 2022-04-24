package entity.tans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Sora Chen
 * @Date 2022/3/23 20:51
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    private String StationName;
    private String level;
    private String equip;
    private Equipment equipment;
    private String OneOrTwo;


    public String toString(){
        return this.getLevel() +
                this.getStationName() +
                "变电站 " +
                this.getEquip() +
                "保护第"+
                this.getOneOrTwo()+
                "套保护（" +
                this.getEquipment().getName() +
                "）全部校验标准化试验报告";
    }
}
