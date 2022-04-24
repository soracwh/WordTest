package util.Trans;

import java.util.Random;

/**
 * @Author Sora Chen
 * @Date 2022/3/25 22:23
 * @Version 1.0
 */
public class TransRandomUtil {

    public static String[] getSourceRandom(){
        double[] first = {5.0,12.0,-12.0,24.0,24.0};
        String[] res = new String[5];
        for (int i = 0; i < first.length; i++) {
            Random r = new Random();
            //first[i] =(double) Math.round((first[i]+(0.5-r.nextDouble())/2.5)* 10)/10;
            res[i] = String.format("%.2f",first[i]+(0.5-r.nextDouble())/2.5);
        }
        return res;
    }

    public static String[] getComplexVoltage(){
        String[] res = new String[6];
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            res[2*i] = String.format("%.2f",60+(1-r.nextDouble()));
            res[2*i+1] = String.format("%.2f",4+(1-r.nextDouble())/5);
        }
        return res;
    }

    public static String addTime(String time){
        Random r = new Random();
        int res = Integer.parseInt(time)+r.nextInt(15)+20;
        return String.valueOf(res);
    }


    public static int[] getAngleRandom(){
        int[] angle = new int[42];
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            angle[i]+=(1-r.nextInt(2));
        }
        for (int i = 21; i < 41; i++) {
            angle[i]+=(121-r.nextInt(2));
        }
        return angle;
    }

    /*
    * 电压电流采样随机数
    * */
    public static String[] getVORandom(int num){
        String[] res = new String[24];
        Random r = new Random();
        if(num==1){
            for (int i = 0; i < res.length; i++) {
                res[i] = String.format("%.2f",r.nextDouble()/50);
            }
        }
        for (int i = 0; i < 3; i++) {
            voltage(num, res, r, i);
        }
        for (int i = 4; i < 9; i++) {
            current(num, res, r, i);
        }
        for (int i = 9; i < 12; i++) {
            voltage(num, res, r, i);
        }
        for (int i = 13; i < 18; i++) {
            current(num, res, r, i);
        }
        for (int i = 18; i < 21; i++) {
            voltage(num, res, r, i);
        }
        for (int i = 21; i < 24; i++) {
            current(num, res, r, i);
        }
        res[3] = String.format("%.2f",r.nextDouble()/50);
        res[12] = String.format("%.2f",r.nextDouble()/50);
        return res;
    }

    private static void current(int num, String[] res, Random r, int i) {
        switch (num){
            case 5:
                res[i] = String.format("%.2f",25+(0.5-r.nextDouble())/10);
                break;
            case 4:
                res[i] = String.format("%.2f",5+(0.5-r.nextDouble())/10);
                break;
            case 3:
                res[i] = String.format("%.2f",1+(0.5-r.nextDouble())/25);
                break;
            case 2:
                res[i] = String.format("%.2f",0.5+(0.5-r.nextDouble())/25);
                break;
        }
    }

    private static void voltage(int num, String [] res, Random r, int i) {
        switch (num){
            case 5:
                res[i] = String.format("%.2f",60+(0.5-r.nextDouble())/10);
                break;
            case 4:
                res[i] = String.format("%.2f",30+(0.5-r.nextDouble())/10);
                break;
            case 3:
                res[i] = String.format("%.2f",5+(0.5-r.nextDouble())/25);
                break;
            case 2:
                res[i] = String.format("%.2f",1+(0.5-r.nextDouble())/25);
                break;
        }
    }

}
