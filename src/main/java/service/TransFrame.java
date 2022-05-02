package service;


import javax.swing.*;
import java.awt.*;

/**
 * @Author Sora Chen
 * @Date 2022/4/10 15:56
 * @Version 1.0
 */
public class TransFrame extends JFrame{
    private final JComboBox<String> Kind = new JComboBox<>();
    private final JTextField eVoltage = new JTextField("220V");
    private final JComboBox<String> VLevel = new JComboBox<>();
    private final JTextField stationName = new JTextField("");
    private final JTextField equipment = new JTextField("");
    private final JComboBox<String> num = new JComboBox<>();
    private final JTextField eFactory = new JTextField("");
    private final JTextField eName = new JTextField("");
    private final JTextField eCRC = new JTextField("");
    private final JTextField eCurrent = new JTextField("5A");
    private final JTextField ePassword = new JTextField("");
    private final JTextField eTime = new JTextField("");
    private final JTextField eVersion = new JTextField("");
    private final JTextField HighCapacity = new JTextField("");
    private final JTextField HighVoltage = new JTextField("");
    private final JTextField HighRation = new JTextField("1600");
    private final JTextField HighCurrent = new JTextField("5");
    private final JTextField MiddleCapacity = new JTextField("");
    private final JTextField MiddleVoltage = new JTextField("");
    private final JTextField MiddleRation = new JTextField("1600");
    private final JTextField MiddleCurrent = new JTextField("5");
    private final JTextField LowCapacity = new JTextField("");
    private final JTextField LowVoltage = new JTextField("");
    private final JTextField LowRation = new JTextField("1600");
    private final JTextField LowCurrent = new JTextField("5");
    private final JTextField differentialCurrent = new JTextField("0.5");
    private final JTextField differentialFastCurrent = new JTextField("");
    private final JTextField harmonic = new JTextField("15");
    private final JTextField differentialWarning = new JTextField("");
    private final JTextField differentialWarningTime = new JTextField("");

    private final JComboBox<String> highComplexNum = new JComboBox<>();
    private final JTextField High1_current = new JTextField("");
    private final JTextField High1_time = new JTextField("");
    private final JTextField High2_current = new JTextField("");
    private final JTextField High2_time = new JTextField("");
    private final JTextField High3_current = new JTextField("");
    private final JTextField High3_time = new JTextField("");

    private final JComboBox<String> highComplexNum2 = new JComboBox<>();
    private final JTextField High2_1_current = new JTextField("");
    private final JTextField High2_1_time = new JTextField("");
    private final JTextField High2_2_current = new JTextField("");
    private final JTextField High2_2_time = new JTextField("");
    private final JTextField High2_3_current = new JTextField("");
    private final JTextField High2_3_time = new JTextField("");

    private final JComboBox<String> highZeroNum = new JComboBox<>();
    private final JTextField HighZero1_current = new JTextField("");
    private final JTextField HighZero1_time = new JTextField("");
    private final JTextField HighZero2_current = new JTextField("");
    private final JTextField HighZero2_time = new JTextField("");
    private final JTextField HighZero3_current = new JTextField("");
    private final JTextField HighZero3_time = new JTextField("");

    private final JComboBox<String> highZeroNum2 = new JComboBox<>();
    private final JTextField HighZero2_1_current = new JTextField("");
    private final JTextField HighZero2_1_time = new JTextField("");
    private final JTextField HighZero2_2_current = new JTextField("");
    private final JTextField HighZero2_2_time = new JTextField("");
    private final JTextField HighZero2_3_current = new JTextField("");
    private final JTextField HighZero2_3_time = new JTextField("");

    private final JComboBox<String> middleComplexNum = new JComboBox<>();
    private final JTextField Middle1_current = new JTextField("");
    private final JTextField Middle1_time = new JTextField("");
    private final JTextField Middle2_current = new JTextField("");
    private final JTextField Middle2_time = new JTextField("");
    private final JTextField Middle3_current = new JTextField("");
    private final JTextField Middle3_time = new JTextField("");

    private final JComboBox<String> middleComplexNum2 = new JComboBox<>();
    private final JTextField Middle2_1_current = new JTextField("");
    private final JTextField Middle2_1_time = new JTextField("");
    private final JTextField Middle2_2_current = new JTextField("");
    private final JTextField Middle2_2_time = new JTextField("");
    private final JTextField Middle2_3_current = new JTextField("");
    private final JTextField Middle2_3_time = new JTextField("");

    private final JComboBox<String> middleZeroNum = new JComboBox<>();
    private final JTextField MiddleZero1_current = new JTextField("");
    private final JTextField MiddleZero1_time = new JTextField("");
    private final JTextField MiddleZero2_current = new JTextField("");
    private final JTextField MiddleZero2_time = new JTextField("");
    private final JTextField MiddleZero3_current = new JTextField("");
    private final JTextField MiddleZero3_time = new JTextField("");

    private final JComboBox<String> middleZeroNum2 = new JComboBox<>();
    private final JTextField MiddleZero2_1_current = new JTextField("");
    private final JTextField MiddleZero2_1_time = new JTextField("");
    private final JTextField MiddleZero2_2_current = new JTextField("");
    private final JTextField MiddleZero2_2_time = new JTextField("");
    private final JTextField MiddleZero2_3_current = new JTextField("");
    private final JTextField MiddleZero2_3_time = new JTextField("");

    private final JComboBox<String> lowComplexNum = new JComboBox<>();
    private final JTextField Low1_current = new JTextField("");
    private final JTextField Low1_time = new JTextField("");
    private final JTextField Low2_current = new JTextField("");
    private final JTextField Low2_time = new JTextField("");
    private final JTextField Low3_current = new JTextField("");
    private final JTextField Low3_time = new JTextField("");

    private final JComboBox<String> lowComplexNum2 = new JComboBox<>();
    private final JTextField Low2_1_current = new JTextField("");
    private final JTextField Low2_1_time = new JTextField("");
    private final JTextField Low2_2_current = new JTextField("");
    private final JTextField Low2_2_time = new JTextField("");
    private final JTextField Low2_3_current = new JTextField("");
    private final JTextField Low2_3_time = new JTextField("");

    private final JTextField OverLoadCurrent = new JTextField("");
    private final JTextField OverLoadTime = new JTextField("");
    private final JTextField HighGapZeroRation = new JTextField("");
    private final JTextField HighGapZeroCurrent = new JTextField("");
    private final JTextField HighGapZeroTime = new JTextField("");
    private final JTextField MiddleGapZeroRation = new JTextField("");
    private final JTextField MiddleGapZeroCurrent = new JTextField("");
    private final JTextField MiddleGapZeroTime = new JTextField("");

    private final JComboBox<String> InnerOuter = new JComboBox<>();
    private final JTextField ZeroVoltageTime = new JTextField("");

    private final JCheckBox PrepareMiddle = new JCheckBox("110kV备自投",true);
    private final JCheckBox PrepareLow = new JCheckBox("35kV备自投",true);

    public TransFrame(){
        setVisible(true);
        setBounds(400,0,950,700);
        setTitle("主变保护");
        JPanel panel=new JPanel();
        panel.setLayout(null);
        add(panel);
        //输入变电站信息
        stationMessage(panel);
        //输入保护装置信息
        protectMessage(panel);

        //常规智能
        Kind.addItem("常规站");
        Kind.addItem("智能站");
        Kind.setBounds(150,13,100,30);
        panel.add(Kind);


        //提交按钮
        JButton button = new JButton("生成新报告");
        button.setBounds(750,40,100,50);
        TransHandler transHandler =new TransHandler(this);
        button.addActionListener(transHandler);
        panel.add(button);

        //变压器参数
        JLabel label1 = new JLabel("变压器保护:");
        label1.setFont(new Font("宋体",Font.BOLD,15));
        label1.setBounds(20,190,200,30);
        panel.add(label1);
        MainProtect(panel, "高压侧  容量(MVA):", 220,HighCapacity, HighVoltage,HighRation,HighCurrent);
        MainProtect(panel,"中压侧  容量(MVA):", 250,MiddleCapacity, MiddleVoltage,MiddleRation,MiddleCurrent);
        MainProtect(panel, "低压侧  容量(MVA):", 280,LowCapacity, LowVoltage,LowRation,LowCurrent);

        //差动保护
        differential(panel);

        //后备保护
        JLabel label2 = new JLabel("后备保护:");
        label2.setFont(new Font("宋体",Font.BOLD,15));
        label2.setBounds(20,390,200,30);
        panel.add(label2);
        PrepareMiddle.setBounds(100,390,200,30);
        panel.add(PrepareMiddle);
        PrepareLow.setBounds(220,390,200,30);
        panel.add(PrepareLow);

        //高复流
        //reverseLabel(20,420,panel,highComplexNum,"高压复压过流1：");
        //时间和电流
        ReserveProtect(20,420,panel,High1_current,High1_time,High2_time,High3_time,highComplexNum,"高压复压过流1：");
        ReserveProtect(480,420,panel,High2_1_current,High2_1_time,High2_2_time,High2_3_time,highComplexNum2,"高压复压过流2：");
        //TimeCurrent(120,420,panel,High1_current,High1_time,High2_current,High2_time,High3_current,High3_time);
        //reverseLabel(420,420,panel,highComplexNum2,"高压复压过流2：");
        //TimeCurrent(520,420,panel,High2_1_current,High2_1_time,High2_2_current,High2_2_time,High2_3_current,High2_3_time);

//        reverseLabel(20,480,panel,highZeroNum,"高压零序过流1:");
//        TimeCurrent(120,480,panel,HighZero1_current,HighZero1_time,HighZero2_current,HighZero2_time,HighZero3_current,HighZero3_time);
//        reverseLabel(420,480,panel,highZeroNum2,"高压零序过流2");
//        TimeCurrent(520,480,panel,HighZero2_1_current,HighZero2_1_time,HighZero2_2_current,HighZero2_2_time,HighZero2_3_current,HighZero2_3_time);
        ReserveProtect(20,450,panel,HighZero1_current,HighZero1_time,HighZero2_time,HighZero3_time,highZeroNum,"高压零序过流1:");
        ReserveProtect(480,450,panel,HighZero2_1_current,HighZero2_1_time,HighZero2_2_time,HighZero2_3_time,highZeroNum2,"高压零序过流2");

/*        reverseLabel(20,540,panel,middleComplexNum,"中压复压过流1:");
        TimeCurrent(120,540,panel,Middle1_current,Middle1_time,Middle2_current,Middle2_time,Middle3_current,Middle3_time);
        reverseLabel(420,540,panel,middleComplexNum2,"中压复压过流2:");
        TimeCurrent(520,540,panel,Middle2_1_current,Middle2_1_time,Middle2_2_current,Middle2_2_time,Middle2_3_current,Middle2_3_time);*/
        ReserveProtect(20,480,panel,Middle1_current,Middle1_time,Middle2_time,Middle3_time,middleComplexNum,"中压复压过流1:");
        ReserveProtect(480,480,panel,Middle2_1_current,Middle2_1_time,Middle2_2_time,Middle2_3_time,middleComplexNum2,"中压复压过流2:");

//        reverseLabel(20,600,panel,middleZeroNum,"中压零序过流1:");
//        TimeCurrent(120,600,panel,MiddleZero1_current,MiddleZero1_time,MiddleZero2_current,MiddleZero2_time,MiddleZero3_current,MiddleZero3_time);
//        reverseLabel(420,600,panel,middleZeroNum2,"中压零序过流2:");
//        TimeCurrent(520,600,panel,MiddleZero2_1_current,MiddleZero2_1_time,MiddleZero2_2_current,MiddleZero2_2_time,MiddleZero2_3_current,MiddleZero2_3_time);
        ReserveProtect(20,510,panel,MiddleZero1_current,MiddleZero1_time,MiddleZero2_time,MiddleZero3_time,middleZeroNum,"中压零序过流1:");
        ReserveProtect(480,510,panel,MiddleZero2_1_current,MiddleZero2_1_time,MiddleZero2_2_time,MiddleZero2_3_time,middleZeroNum2,"中压零序过流1:");

//        reverseLabel(20,660,panel,lowComplexNum,"低压复压过流1:");
//        TimeCurrent(120,660,panel,Low1_current,Low1_time,Low2_current,Low2_time,Low3_current,Low3_time);
//        reverseLabel(420,660,panel,lowComplexNum2,"低压复压过流2:");
//        TimeCurrent(520,660,panel,Low2_1_current,Low2_1_time,Low2_2_current,Low2_2_time,Low2_3_current,Low2_3_time);
        ReserveProtect(20,540,panel,Low1_current,Low1_time,Low2_time,Low3_time,lowComplexNum,"低压复压过流1:");
        ReserveProtect(480,540,panel,Low2_1_current,Low2_1_time,Low2_2_time,Low2_3_time,lowComplexNum2,"低压复压过流2:");

        //其他保护
        JLabel label3 = new JLabel("其他保护:");
        label3.setFont(new Font("宋体",Font.BOLD,15));
        label3.setBounds(20,580,200,30);
        panel.add(label3);
        otherProtect(panel);

    }
    private void otherProtect(JPanel panel){
        JLabel label1 = new JLabel("间隙零流(CT变比)：高");
        label1.setBounds(20,610,130,30);
        panel.add(label1);
        HighGapZeroRation.setBounds(150,610,50,30);
        panel.add(HighGapZeroRation);
        JLabel label2 = new JLabel("：");
        label2.setBounds(205,610,100,30);
        panel.add(label2);
        HighGapZeroCurrent.setBounds(215,610,50,30);
        panel.add(HighGapZeroCurrent);
        JLabel label6 = new JLabel("时间");
        label6.setBounds(270,610,50,30);
        panel.add(label6);
        HighGapZeroTime.setBounds(300,610,50,30);
        panel.add(HighGapZeroTime);

        JLabel label5 = new JLabel("中");
        label5.setBounds(370,610,120,30);
        panel.add(label5);
        MiddleGapZeroRation.setBounds(390,610,50,30);
        panel.add(MiddleGapZeroRation);
        JLabel label3 = new JLabel("：");
        label3.setBounds(440,610,100,30);
        panel.add(label3);
        MiddleGapZeroCurrent.setBounds(450,610,50,30);
        panel.add(MiddleGapZeroCurrent);
        JLabel label7 = new JLabel("时间");
        label7.setBounds(505,610,50,30);
        panel.add(label7);
        MiddleGapZeroTime.setBounds(535,610,50,30);
        panel.add(MiddleGapZeroTime);

        JLabel label4 = new JLabel("零压保护：");
        label4.setBounds(600,610,120,30);
        panel.add(label4);
        InnerOuter.setBounds(655,612,80,30);
        InnerOuter.addItem("外接");
        InnerOuter.addItem("自产");
        InnerOuter.addItem("-");
        panel.add(InnerOuter);
        JLabel label8 = new JLabel("时间：");
        label8.setBounds(735,610,120,30);
        panel.add(label8);
        ZeroVoltageTime.setBounds(765,610,50,30);
        panel.add(ZeroVoltageTime);

    }

    private void TimeAndCurrent(int x,int y,JPanel panel,JTextField current,JTextField time,
                                JTextField current1,JTextField time1,JTextField current2,JTextField time2,JTextField current3,JTextField time3){
        TimeCurrent(x, y, panel, current, time, current1, time1, current2, time2);

//        JLabel label3 = new JLabel("无方向(A):");
//        label3.setBounds(x+270,y,90,30);
//        panel.add(label3);
//        current3.setBounds(x+330,y,50,30);
//        panel.add(current3);
//        JLabel label4 = new JLabel("时间(ms):");
//        label4.setBounds(x+270,y+30,90,30);
//        panel.add(label4);
//        time3.setBounds(x+330,y+30,50,30);
//        panel.add(time3);
    }


    private void TimeCurrent(int x, int y, JPanel panel, JTextField current, JTextField time, JTextField current1, JTextField time1, JTextField current2, JTextField time2) {
        JLabel label1 = new JLabel("1/2/3时限(A):");
        label1.setBounds(x, y, 90, 30);
        panel.add(label1);
        current.setBounds(x + 90, y, 50, 30);
        panel.add(current);
        current1.setBounds(x + 150, y, 50, 30);
        panel.add(current1);
        current2.setBounds(x + 210, y, 50, 30);
        panel.add(current2);
        JLabel label2 = new JLabel("时间(ms):");
        label2.setBounds(x + 30, y + 30, 90, 30);
        panel.add(label2);
        time.setBounds(x + 90, y + 30, 50, 30);
        panel.add(time);
        time1.setBounds(x + 150, y + 30, 50, 30);
        panel.add(time1);
        time2.setBounds(x + 210, y + 30, 50, 30);
        panel.add(time2);
    }

    private void ReserveProtect(int x, int y, JPanel panel, JTextField current, JTextField time1, JTextField time2, JTextField time3,JComboBox<String> jComboBox,String s) {
        JLabel label3 = new JLabel(s);
        label3.setFont(new Font("宋体",Font.BOLD,13));
        label3.setBounds(x,y,100,30);
        panel.add(label3);
        jComboBox.setBounds(x+90,y+2,60,30);
        panel.add(jComboBox);
        jComboBox.addItem("II");
        jComboBox.addItem("I");
        jComboBox.addItem("III");
        jComboBox.addItem("-");
        current.setBounds(x + 150, y, 50, 30);
        panel.add(current);
        JLabel label2 = new JLabel("三段(ms):");
        label2.setBounds(x + 205,y,80,30);
        panel.add(label2);
        time1.setBounds(x + 270, y, 50, 30);
        panel.add(time1);
        time2.setBounds(x + 330, y, 50, 30);
        panel.add(time2);
        time3.setBounds(x + 390, y, 50, 30);
        panel.add(time3);
    }

    /*private void reverseLabel(int x,int y,JPanel panel,JComboBox<String> jComboBox,String s) {
        JLabel label3 = new JLabel(s);
        label3.setFont(new Font("宋体",Font.BOLD,13));
        label3.setBounds(x,y,100,30);
        panel.add(label3);
        JLabel label1 = new JLabel("第几段");
        label1.setBounds(x,y+30,60,30);
        panel.add(label1);
        jComboBox.setBounds(x+40,y+32,60,30);
        panel.add(jComboBox);
        jComboBox.addItem("II");
        jComboBox.addItem("I");
        jComboBox.addItem("III");
        jComboBox.addItem("-");
    }*/

    private void differential(JPanel panel){
        JLabel label = new JLabel("差动保护:");
        label.setFont(new Font("宋体",Font.BOLD,15));
        label.setBounds(20,320,200,30);
        panel.add(label);
        JLabel label1 = new JLabel("差动电流定值(Ie)：");
        label1.setBounds(20,350,120,30);
        panel.add(label1);
        differentialCurrent.setBounds(120,350,50,30);
        panel.add(differentialCurrent);
        JLabel label2 = new JLabel("差动速断(Ie)：");
        label2.setBounds(190,350,100,30);
        panel.add(label2);
        differentialFastCurrent.setBounds(270,350,50,30);
        panel.add(differentialFastCurrent);
        JLabel label3 = new JLabel("二次谐波：");
        label3.setBounds(340,350,80,30);
        panel.add(label3);
        harmonic.setBounds(400,350,50,30);
        panel.add(harmonic);
        JLabel label4 = new JLabel("差流告警(Ie)：");
        label4.setBounds(470,350,100,30);
        panel.add(label4);
        differentialWarning.setBounds(550,350,50,30);
        panel.add(differentialWarning);
        JLabel label8 = new JLabel("时间：");
        label8.setBounds(610,350,100,30);
        panel.add(label8);
        differentialWarningTime.setBounds(645,350,50,30);
        panel.add(differentialWarningTime);

        JLabel label5 = new JLabel("过负荷(Ie)：");
        label5.setBounds(710,350,120,30);
        panel.add(label5);
        OverLoadCurrent.setBounds(775,350,50,30);
        panel.add(OverLoadCurrent);
        JLabel label6 = new JLabel("时间：");
        label6.setBounds(830,350,100,30);
        panel.add(label6);
        OverLoadTime.setBounds(870,350,50,30);
        panel.add(OverLoadTime);
    }
    private void MainProtect(JPanel panel, String s, int y,JTextField Capacity,
                             JTextField Voltage,JTextField Ration,JTextField Current) {
        JLabel label1 = new JLabel(s);
        label1.setBounds(20, y, 200, 30);
        panel.add(label1);
        Capacity.setBounds(140, y, 80, 30);
        panel.add(Capacity);
        JLabel label2 = new JLabel("电压(kV)：");
        label2.setBounds(240,y,80,30);
        panel.add(label2);
        Voltage.setBounds(300,y,80,30);
        panel.add(Voltage);
        JLabel label3 = new JLabel("电流变比：");
        label3.setBounds(400,y,80,30);
        panel.add(label3);
        Ration.setBounds(470,y,60,30);
        panel.add(Ration);
        JLabel label4 = new JLabel(":");
        label4.setBounds(540,y,80,30);
        panel.add(label4);
        Current.setBounds(555,y,60,30);
        panel.add(Current);
    }

    private void stationMessage(JPanel panel) {
            JLabel stationLabel = new JLabel("输入变电站信息:");
            stationLabel.setBounds(20,10,200,30);
            stationLabel.setFont(new Font("宋体",Font.BOLD,15));
            panel.add(stationLabel);
            JLabel label1 = new JLabel("电压等级：");
            label1.setBounds(20,45,80,30);
            panel.add(label1);
            VLevel.addItem("220kV");
            VLevel.addItem("110kV");
            VLevel.setBounds(80,47,100,30);
            panel.add(VLevel);
            JLabel label2 = new JLabel("变电站：");
            label2.setBounds(200,45,60,30);
            panel.add(label2);
            stationName.setBounds(260,45,80,30);
            panel.add(stationName);
            JLabel label3 = new JLabel("设备：");
            label3.setBounds(360,45,80,30);
            panel.add(label3);
            equipment.setBounds(400,45,80,30);
            panel.add(equipment);
            JLabel label4 = new JLabel("第几套：");
            label4.setBounds(500,45,60,30);
            panel.add(label4);
            num.addItem("1");
            num.addItem("2");
            num.setBounds(550,47,70,30);
            panel.add(num);
        }

        private void protectMessage(JPanel panel) {
            JLabel equipLabel = new JLabel("输入装置信息:");
            equipLabel.setBounds(20,90,200,30);
            equipLabel.setFont(new Font("宋体",Font.BOLD,15));
            panel.add(equipLabel);
            JLabel label5 = new JLabel("型号：");
            label5.setBounds(20,120,60,30);
            panel.add(label5);
            eName.setBounds(80,120,100,30);
            panel.add(eName);
            JLabel label6 = new JLabel("厂家：");
            label6.setBounds(220,120,60,30);
            panel.add(label6);
            eFactory.setBounds(260,120,80,30);
            panel.add(eFactory);
            JLabel label7 = new JLabel("CRC：");
            label7.setBounds(360,120,60,30);
            panel.add(label7);
            eCRC.setBounds(400,120,80,30);
            panel.add(eCRC);
            JLabel label8 = new JLabel("版本：");
            label8.setBounds(500,120,60,30);
            panel.add(label8);
            eVersion.setBounds(540,120,80,30);
            panel.add(eVersion);
            JLabel label9 = new JLabel("日期：");
            label9.setBounds(20,150,60,30);
            panel.add(label9);
            eTime.setBounds(80,150,100,30);
            panel.add(eTime);
            JLabel label10 = new JLabel("电流：");
            label10.setBounds(220,150,60,30);
            panel.add(label10);
            eCurrent.setBounds(260,150,80,30);
            panel.add(eCurrent);
            JLabel label11 = new JLabel("电压：");
            label11.setBounds(360,150,60,30);
            panel.add(label11);
            eVoltage.setBounds(400,150,80,30);
            panel.add(eVoltage);
            JLabel label12 = new JLabel("密码：");
            label12.setBounds(500,150,60,30);
            panel.add(label12);
            ePassword.setBounds(540,150,80,30);
            panel.add(ePassword);
        }

    public JTextField geteVoltage(){
        return eVoltage;
    }

    public JComboBox<String> getVLevel() {
        return VLevel;
    }

    public JTextField getStationName() {
        return stationName;
    }

    public JTextField getEquipment() {
        return equipment;
    }

    public JComboBox<String> getNum() {
        return num;
    }

    public JTextField geteFactory() {
        return eFactory;
    }

    public JTextField geteName() {
        return eName;
    }

    public JTextField geteCRC() {
        return eCRC;
    }

    public JTextField geteCurrent() {
        return eCurrent;
    }

    public JTextField getePassword() {
        return ePassword;
    }

    public JTextField geteTime() {
        return eTime;
    }

    public JTextField geteVersion() {
        return eVersion;
    }

    public JTextField getHighCapacity() {
        return HighCapacity;
    }

    public JTextField getHighVoltage() {
        return HighVoltage;
    }

    public JTextField getHighRation() {
        return HighRation;
    }

    public JTextField getHighCurrent() {
        return HighCurrent;
    }

    public JTextField getMiddleCapacity() {
        return MiddleCapacity;
    }

    public JTextField getMiddleVoltage() {
        return MiddleVoltage;
    }

    public JTextField getMiddleRation() {
        return MiddleRation;
    }

    public JTextField getMiddleCurrent() {
        return MiddleCurrent;
    }

    public JTextField getLowCapacity() {
        return LowCapacity;
    }

    public JTextField getLowVoltage() {
        return LowVoltage;
    }

    public JTextField getLowRation() {
        return LowRation;
    }

    public JTextField getLowCurrent() {
        return LowCurrent;
    }

    public JTextField getDifferentialCurrent() {
        return differentialCurrent;
    }

    public JTextField getDifferentialFastCurrent() {
        return differentialFastCurrent;
    }

    public JTextField getHarmonic() {
        return harmonic;
    }

    public JTextField getDifferentialWarning() {
        return differentialWarning;
    }

    public JComboBox<String> getHighComplexNum() {
        return highComplexNum;
    }

    public JTextField getHigh1_current() {
        return High1_current;
    }

    public JTextField getHigh1_time() {
        return High1_time;
    }

    public JTextField getHigh2_current() {
        return High2_current;
    }

    public JTextField getHigh2_time() {
        return High2_time;
    }

    public JTextField getHigh3_current() {
        return High3_current;
    }

    public JTextField getHigh3_time() {
        return High3_time;
    }

    public JComboBox<String> getHighZeroNum() {
        return highZeroNum;
    }

    public JTextField getHighZero1_current() {
        return HighZero1_current;
    }

    public JTextField getHighZero1_time() {
        return HighZero1_time;
    }

    public JTextField getHighZero2_current() {
        return HighZero2_current;
    }

    public JTextField getHighZero2_time() {
        return HighZero2_time;
    }

    public JTextField getHighZero3_current() {
        return HighZero3_current;
    }

    public JTextField getHighZero3_time() {
        return HighZero3_time;
    }

    public JComboBox<String> getMiddleComplexNum() {
        return middleComplexNum;
    }

    public JTextField getMiddle1_current() {
        return Middle1_current;
    }

    public JTextField getMiddle1_time() {
        return Middle1_time;
    }

    public JTextField getMiddle2_current() {
        return Middle2_current;
    }

    public JTextField getMiddle2_time() {
        return Middle2_time;
    }

    public JTextField getMiddle3_current() {
        return Middle3_current;
    }

    public JTextField getMiddle3_time() {
        return Middle3_time;
    }


    public JComboBox<String> getMiddleZeroNum() {
        return middleZeroNum;
    }

    public JTextField getMiddleZero1_current() {
        return MiddleZero1_current;
    }

    public JTextField getMiddleZero1_time() {
        return MiddleZero1_time;
    }

    public JTextField getMiddleZero2_current() {
        return MiddleZero2_current;
    }

    public JTextField getMiddleZero2_time() {
        return MiddleZero2_time;
    }

    public JTextField getMiddleZero3_current() {
        return MiddleZero3_current;
    }

    public JTextField getMiddleZero3_time() {
        return MiddleZero3_time;
    }

    public JComboBox<String> getLowComplexNum() {
        return lowComplexNum;
    }

    public JTextField getLow1_current() {
        return Low1_current;
    }

    public JTextField getLow1_time() {
        return Low1_time;
    }

    public JTextField getLow2_current() {
        return Low2_current;
    }

    public JTextField getLow2_time() {
        return Low2_time;
    }

    public JTextField getLow3_current() {
        return Low3_current;
    }

    public JTextField getLow3_time() {
        return Low3_time;
    }

    public JComboBox<String> getHighComplexNum2() {
        return highComplexNum2;
    }

    public JTextField getHigh2_1_current() {
        return High2_1_current;
    }

    public JTextField getHigh2_1_time() {
        return High2_1_time;
    }

    public JTextField getHigh2_2_current() {
        return High2_2_current;
    }

    public JTextField getHigh2_2_time() {
        return High2_2_time;
    }

    public JTextField getHigh2_3_current() {
        return High2_3_current;
    }

    public JTextField getHigh2_3_time() {
        return High2_3_time;
    }

    public JComboBox<String> getHighZeroNum2() {
        return highZeroNum2;
    }

    public JTextField getHighZero2_1_current() {
        return HighZero2_1_current;
    }

    public JTextField getHighZero2_1_time() {
        return HighZero2_1_time;
    }

    public JTextField getHighZero2_2_current() {
        return HighZero2_2_current;
    }

    public JTextField getHighZero2_2_time() {
        return HighZero2_2_time;
    }

    public JTextField getHighZero2_3_current() {
        return HighZero2_3_current;
    }

    public JTextField getHighZero2_3_time() {
        return HighZero2_3_time;
    }

    public JComboBox<String> getMiddleComplexNum2() {
        return middleComplexNum2;
    }

    public JTextField getMiddle2_1_current() {
        return Middle2_1_current;
    }

    public JTextField getMiddle2_1_time() {
        return Middle2_1_time;
    }

    public JTextField getMiddle2_2_current() {
        return Middle2_2_current;
    }

    public JTextField getMiddle2_2_time() {
        return Middle2_2_time;
    }

    public JTextField getMiddle2_3_current() {
        return Middle2_3_current;
    }

    public JTextField getMiddle2_3_time() {
        return Middle2_3_time;
    }

    public JComboBox<String> getMiddleZeroNum2() {
        return middleZeroNum2;
    }

    public JTextField getMiddleZero2_1_current() {
        return MiddleZero2_1_current;
    }

    public JTextField getMiddleZero2_1_time() {
        return MiddleZero2_1_time;
    }

    public JTextField getMiddleZero2_2_current() {
        return MiddleZero2_2_current;
    }

    public JTextField getMiddleZero2_2_time() {
        return MiddleZero2_2_time;
    }

    public JTextField getMiddleZero2_3_current() {
        return MiddleZero2_3_current;
    }

    public JTextField getMiddleZero2_3_time() {
        return MiddleZero2_3_time;
    }

    public JComboBox<String> getLowComplexNum2() {
        return lowComplexNum2;
    }

    public JTextField getLow2_1_current() {
        return Low2_1_current;
    }

    public JTextField getLow2_1_time() {
        return Low2_1_time;
    }

    public JTextField getLow2_2_current() {
        return Low2_2_current;
    }

    public JTextField getLow2_2_time() {
        return Low2_2_time;
    }

    public JTextField getLow2_3_current() {
        return Low2_3_current;
    }

    public JTextField getLow2_3_time() {
        return Low2_3_time;
    }

    public JTextField getOverLoadCurrent() {
        return OverLoadCurrent;
    }

    public JTextField getOverLoadTime() {
        return OverLoadTime;
    }

    public JTextField getHighGapZeroTime() {
        return HighGapZeroTime;
    }

    public JTextField getMiddleGapZeroTime() {
        return MiddleGapZeroTime;
    }

    public JComboBox<String> getInnerOuter() {
        return InnerOuter;
    }

    public JTextField getZeroVoltageTime() {
        return ZeroVoltageTime;
    }

    public JTextField getHighGapZeroRation() {
        return HighGapZeroRation;
    }

    public JTextField getHighGapZeroCurrent() {
        return HighGapZeroCurrent;
    }

    public JTextField getMiddleGapZeroRation() {
        return MiddleGapZeroRation;
    }

    public JTextField getMiddleGapZeroCurrent() {
        return MiddleGapZeroCurrent;
    }

    public JCheckBox getPrepareMiddle() {
        return PrepareMiddle;
    }

    public JCheckBox getPrepareLow() {
        return PrepareLow;
    }

    public JTextField getDifferentialWarningTime() {
        return differentialWarningTime;
    }

    public JComboBox<String> getKind() {
        return Kind;
    }
}
