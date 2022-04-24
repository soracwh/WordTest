package entity.tans;

import lombok.Data;

/**
 * @Author Sora Chen
 * @Date 2022/4/20 19:29
 * @Version 1.0
 */

@Data
public class ReserveProtect {

    private String name;
    private String current;
    private String time;
    private String platen;
    private String action;

    public ReserveProtect(String name, String current, String time) {
        this.name = name;
        this.current = current;
        this.time = time;
    }
}
