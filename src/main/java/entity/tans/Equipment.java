package entity.tans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Sora Chen
 * @Date 2022/3/23 21:02
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    private String name;
    private String CRC;
    private String time;
    private String version;
    private String current;
    private String factory;
    private String password;
    private String voltage;

    public Equipment(boolean flag){
        if(flag){
            this.name = "-";
            this.CRC = "-";
            this.time = "-";
            this.version = "-";
            this.current = "-";
            this.factory = "-";
            this.password = "-";
        }else{
              new Equipment();
        }
    }

}
