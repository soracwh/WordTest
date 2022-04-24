package service;

import entity.tans.*;
import transformer.TransMethod;
import util.Trans.CalUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Sora Chen
 * @Date 2022/4/10 15:44
 * @Version 1.0
 */
public class TransHandler implements ActionListener {
    private final TransFrame transFrame;

    public TransHandler(TransFrame transFrame){
        this.transFrame = transFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //程序数据传输
        Title title = new Title();
        title.setStationName(transFrame.getStationName().getText());
        title.setLevel((String) transFrame.getVLevel().getSelectedItem());
        title.setEquip(transFrame.getEquipment().getText());
        title.setOneOrTwo((String) transFrame.getNum().getSelectedItem());
        Equipment equipment = new Equipment(true);
        equipment.setCRC(transFrame.geteCRC().getText());
        equipment.setFactory(transFrame.geteFactory().getText());
        equipment.setCurrent(transFrame.geteCurrent().getText());
        equipment.setName(transFrame.geteName().getText());
        if(transFrame.geteVersion().getText()!=null&&!transFrame.geteVersion().getText().equals("")){
            equipment.setVersion(transFrame.geteVersion().getText());
        }
        if(transFrame.geteTime().getText()!=null&&!transFrame.geteTime().getText().equals("")){
            equipment.setTime(transFrame.geteTime().getText());
        }
        equipment.setVoltage(transFrame.geteVoltage().getText());
        equipment.setPassword(transFrame.getePassword().getText());
        title.setEquipment(equipment);
        //差动保护数据
        MainProtect mainProtect =new MainProtect(transFrame.getHighCapacity().getText(), transFrame.getMiddleCapacity().getText(),
                transFrame.getLowCapacity().getText(), transFrame.getHighVoltage().getText(), transFrame.getMiddleVoltage().getText(),
                transFrame.getLowVoltage().getText(), transFrame.getHighRation().getText(), transFrame.getMiddleRation().getText(),
                transFrame.getLowRation().getText(), transFrame.getHighCurrent().getText(), transFrame.getMiddleCurrent().getText(),
                transFrame.getLowCurrent().getText(), transFrame.getDifferentialCurrent().getText(), transFrame.getDifferentialFastCurrent().getText(),
                transFrame.getHarmonic().getText(), transFrame.getDifferentialWarning().getText()+"Ie",transFrame.getDifferentialWarningTime().getText());
        if(!putIn(transFrame.getDifferentialWarning().getText())){
            mainProtect.setDifferentialWarning("-");
            mainProtect.setDifferentialWarningTime("-");
        }
        if(mainProtect.getDifferentialWarning()==null||mainProtect.getDifferentialWarning().equals("")){
            mainProtect.setDifferentialWarning("-");
        }
        MainProtectCal mainProtectCal = new MainProtectCal();
        CalUtil.getDifferPoint(equipment.getFactory(),mainProtect,mainProtectCal);
        int flag = 2;
        //高复流
        List<ReserveProtect> HighReserve = new ArrayList<>();
        if(putIn(transFrame.getHigh1_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段1时限",transFrame.getHigh1_current().getText(), transFrame.getHigh1_time().getText());
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段1时限（控制字）投退");
            flag--;
            protect.setAction("跳110kV侧断路器");
            HighReserve.add(protect);
        }
        if(putIn(transFrame.getHigh2_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段2时限",transFrame.getHigh2_current().getText(),transFrame.getHigh2_time().getText());
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段2时限（控制字）投退");
            if(flag ==2){
                protect.setAction("跳110kV侧断路器");
            }else {
                protect.setAction("跳主变三侧断路器");
            }
            HighReserve.add(protect);
        }
        if(putIn(transFrame.getHigh3_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段3时限", transFrame.getHigh3_current().getText(),transFrame.getHigh3_time().getText());
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            HighReserve.add(protect);
        }
        int total=0;
        if(putIn(transFrame.getHigh2_1_current().getText())) total++;
        if(putIn(transFrame.getHigh2_2_current().getText())) total++;
        if(putIn(transFrame.getHigh2_3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getHigh2_1_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段1时限",transFrame.getHigh2_1_current().getText(),transFrame.getHigh2_1_time().getText());
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段1时限（控制字）投退");
            if(total==1){
                protect.setAction("跳主变三侧断路器");
            }else{
                flag--;
                protect.setAction("跳110kV侧断路器");
            }
            HighReserve.add(protect);
        }
        if(putIn(transFrame.getHigh2_2_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段2时限",transFrame.getHigh2_2_current().getText(),transFrame.getHigh2_2_time().getText());
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段2时限（控制字）投退");
            if(total==1){
                protect.setAction("跳主变三侧断路器");
            }else{
                if(flag ==2){
                    protect.setAction("跳110kV侧断路器");
                }else {
                    protect.setAction("跳主变三侧断路器");
                }
            }
            HighReserve.add(protect);
        }
        if(putIn(transFrame.getHigh2_3_current().getText())) {
            ReserveProtect protect = new ReserveProtect("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段3时限", transFrame.getHigh2_3_current().getText(),transFrame.getHigh2_3_time().getText());
            HighReserve.add(protect);
            protect.setPlaten("高压侧复压方向过流"+transFrame.getHighComplexNum2().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
        }
        //高零流
        flag = 2;
        List<ReserveProtect> HighZeroProtect = new ArrayList<>();
        if(putIn(transFrame.getHighZero1_current().getText())){
            ReserveProtect protect = new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum().getSelectedItem()+"段1时限",transFrame.getHighZero1_current().getText(), transFrame.getHighZero1_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum().getSelectedItem()+"段1时限（控制字）投退");
            flag--;
            protect.setAction("跳110kV侧断路器");
            HighZeroProtect.add(protect);
        }
        if(putIn(transFrame.getHighZero2_current().getText())){
            ReserveProtect protect =  new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum().getSelectedItem()+"段2时限",transFrame.getHighZero2_current().getText(), transFrame.getHighZero2_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum().getSelectedItem()+"段2时限（控制字）投退");
            if(flag ==2){
                protect.setAction("跳110kV侧断路器");
            }else {
                protect.setAction("跳主变三侧断路器");
            }
            HighZeroProtect.add(protect);
        }
        if(putIn(transFrame.getHighZero3_current().getText())){
            ReserveProtect protect = new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum().getSelectedItem()+"段3时限",transFrame.getHighZero3_current().getText(), transFrame.getHighZero3_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            HighZeroProtect.add(protect);
        }
        total = 0;
        if(putIn(transFrame.getHighZero2_1_current().getText())) total++;
        if(putIn(transFrame.getHighZero2_2_current().getText())) total++;
        if(putIn(transFrame.getHighZero2_3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getHighZero2_1_current().getText())){
            ReserveProtect protect = new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段1时限",transFrame.getHighZero2_1_current().getText(), transFrame.getHighZero2_1_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段1时限（控制字）投退");
            if(total==1){
                protect.setAction("跳主变三侧断路器");
            }else{
                flag--;
                protect.setAction("跳110kV侧断路器");
            }
            HighZeroProtect.add(protect);
        }
        if(putIn(transFrame.getHighZero2_2_current().getText())){
            ReserveProtect protect =  new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段2时限",transFrame.getHighZero2_2_current().getText(), transFrame.getHighZero2_2_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段2时限（控制字）投退");
            if(total==1){
                protect.setAction("跳主变三侧断路器");
            }else{
                if(flag ==2){
                    protect.setAction("跳110kV侧断路器");
                }else {
                    protect.setAction("跳主变三侧断路器");
                }
            }
            HighZeroProtect.add(protect);
        }
        if(putIn(transFrame.getHighZero2_3_current().getText())){
            ReserveProtect protect = new ReserveProtect("高压侧零序过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段3时限",transFrame.getHighZero2_3_current().getText(), transFrame.getHighZero2_3_time().getText());
            protect.setPlaten("高压侧零序方向过流"+transFrame.getHighZeroNum2().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            HighZeroProtect.add(protect);
        }

        //中复压
        List<ReserveProtect> MiddleReserve = new ArrayList<>();
        total = 0;
        if(putIn(transFrame.getMiddle1_current().getText())) total++;
        if(putIn(transFrame.getMiddle2_current().getText())) total++;
        if(putIn(transFrame.getMiddle3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getMiddle1_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段1时限",transFrame.getMiddle1_current().getText(), transFrame.getMiddle1_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳110kV母分断路器");
            }else{
                protect.setAction("跳110kV侧断路器");
                flag--;
            }
            MiddleReserve.add(protect);
        }
        if(putIn(transFrame.getMiddle2_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段2时限",transFrame.getMiddle2_current().getText(),transFrame.getMiddle2_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                protect.setAction("跳110kV侧断路器");
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleReserve.add(protect);
        }
        if(putIn(transFrame.getMiddle3_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段3时限", transFrame.getMiddle3_current().getText(),transFrame.getMiddle3_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum().getSelectedItem()+"段2时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            MiddleReserve.add(protect);
        }

        total = 0;
        if(putIn(transFrame.getMiddle2_1_current().getText())) total++;
        if(putIn(transFrame.getMiddle2_2_current().getText())) total++;
        if(putIn(transFrame.getMiddle2_3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getMiddle2_1_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段1时限",transFrame.getMiddle2_1_current().getText(), transFrame.getMiddle2_1_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳110kV母分断路器");
            }else if(total==2){
                protect.setAction("跳110kV侧断路器");
                flag--;
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleReserve.add(protect);
        }
        if(putIn(transFrame.getMiddle2_2_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段2时限",transFrame.getMiddle2_2_current().getText(),transFrame.getMiddle2_2_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                protect.setAction("跳110kV侧断路器");
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleReserve.add(protect);
        }
        if(putIn(transFrame.getMiddle3_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段3时限", transFrame.getMiddle2_3_current().getText(),transFrame.getMiddle2_3_time().getText());
            protect.setPlaten("中压侧复压方向过流"+transFrame.getMiddleComplexNum2().getSelectedItem()+"段2时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            MiddleReserve.add(protect);
        }

        //中零流
        List<ReserveProtect> MiddleZeroProtect =new ArrayList<>();
        total = 0;
        if(putIn(transFrame.getMiddleZero1_current().getText())) total++;
        if(putIn(transFrame.getMiddleZero2_current().getText())) total++;
        if(putIn(transFrame.getMiddleZero2_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getMiddleZero1_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段1时限",transFrame.getMiddleZero1_current().getText(), transFrame.getMiddleZero1_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳110kV母分断路器");
            }else{
                protect.setAction("跳110kV侧断路器");
                flag--;
            }
            MiddleZeroProtect.add(protect);
        }
        if(putIn(transFrame.getMiddleZero2_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段2时限",transFrame.getMiddleZero2_current().getText(), transFrame.getMiddleZero2_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                protect.setAction("跳110kV侧断路器");
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleZeroProtect.add(protect);
        }
        if(putIn(transFrame.getMiddleZero3_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段3时限",transFrame.getMiddleZero3_current().getText(), transFrame.getMiddleZero3_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            MiddleZeroProtect.add(protect);
        }

        total = 0;
        if(putIn(transFrame.getMiddleZero2_1_current().getText())) total++;
        if(putIn(transFrame.getMiddleZero2_2_current().getText())) total++;
        if(putIn(transFrame.getMiddleZero2_3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getMiddleZero2_1_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段1时限",transFrame.getMiddleZero2_1_current().getText(), transFrame.getMiddleZero2_1_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳110kV母分断路器");
            }else if(total==2){
                protect.setAction("跳110kV侧断路器");
                flag--;
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleZeroProtect.add(protect);
        }
        if(putIn(transFrame.getMiddleZero2_2_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段2时限",transFrame.getMiddleZero2_2_current().getText(),transFrame.getMiddleZero2_2_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                protect.setAction("跳110kV侧断路器");
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            MiddleZeroProtect.add(protect);
        }
        if(putIn(transFrame.getMiddleZero2_3_current().getText())){
            ReserveProtect protect = new ReserveProtect("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段3时限",transFrame.getMiddleZero2_3_current().getText(),transFrame.getMiddleZero2_3_time().getText());
            protect.setPlaten("中压侧零序方向过流"+transFrame.getMiddleZeroNum2().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            MiddleZeroProtect.add(protect);
        }

        //低复流
        List<ReserveProtect> LowReserve =new ArrayList<>();
        total = 0;
        if(putIn(transFrame.getLow1_current().getText())) total++;
        if(putIn(transFrame.getLow2_current().getText())) total++;
        if(putIn(transFrame.getLow3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getLow1_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段1时限",transFrame.getLow1_current().getText(), transFrame.getLow1_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳35kV母分断路器");
            }else if(total==2){
                if(transFrame.getPrepareLow().isSelected()){
                    protect.setAction("跳35kV侧断路器,闭锁35kV备自投");
                }else{
                    protect.setAction("跳35kV侧断路器");
                }
                flag--;
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            LowReserve.add(protect);
        }
        if(putIn(transFrame.getLow2_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段2时限",transFrame.getLow2_current().getText(),transFrame.getLow2_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                if(transFrame.getPrepareLow().isSelected()){
                    protect.setAction("跳35kV侧断路器,闭锁35kV备自投");
                }else{
                    protect.setAction("跳35kV侧断路器");
                }
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            LowReserve.add(protect);
        }
        if(putIn(transFrame.getLow3_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段3时限", transFrame.getLow3_current().getText(),transFrame.getLow3_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            LowReserve.add(protect);
        }

        total = 0;
        if(putIn(transFrame.getLow2_1_current().getText())) total++;
        if(putIn(transFrame.getLow2_2_current().getText())) total++;
        if(putIn(transFrame.getLow2_3_current().getText())) total++;
        flag = total;
        if(putIn(transFrame.getLow2_1_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段1时限",transFrame.getLow2_1_current().getText(),transFrame.getLow2_1_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段1时限（控制字）投退");
            if(total==3) {
                protect.setAction("跳35kV母分断路器");
            }else if(total==2){
                protect.setAction("跳35kV侧断路器");
                flag--;
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            LowReserve.add(protect);
        }
        if(putIn(transFrame.getLow2_2_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段2时限",transFrame.getLow2_2_current().getText(),transFrame.getLow2_2_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段2时限（控制字）投退");
            if(total==3||flag == 2) {
                protect.setAction("跳35kV侧断路器");
            }else{
                protect.setAction("跳主变三侧断路器");
            }
            LowReserve.add(protect);
        }
        if(putIn(transFrame.getLow2_3_current().getText())){
            ReserveProtect protect = new ReserveProtect("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段3时限", transFrame.getLow2_3_current().getText(),transFrame.getLow2_3_time().getText());
            protect.setPlaten("低压侧复压方向过流"+transFrame.getLowComplexNum2().getSelectedItem()+"段3时限（控制字）投退");
            protect.setAction("跳主变三侧断路器");
            LowReserve.add(protect);
        }

        //其他保护
        OtherProtect otherProtect = new OtherProtect();
        if(!putIn(transFrame.getOverLoadCurrent().getText())){
            otherProtect.setOverLoadCurrent("-");
            otherProtect.setOverLoadTime("-");
        }else {
            otherProtect.setOverLoadCurrent(transFrame.getOverLoadCurrent().getText()+"In");
            otherProtect.setOverLoadTime(transFrame.getOverLoadTime().getText());
        }
        if(putIn(transFrame.getHighGapZeroRation().getText())){
            int ration = Integer.parseInt(transFrame.getHighGapZeroCurrent().getText());
            int current = Integer.parseInt(transFrame.getHighGapZeroCurrent().getText());
            int v = 100/ration*current;
            otherProtect.setHighGapZeroCurrent(String.valueOf(v));
            otherProtect.setHighGapZeroTime(transFrame.getHighGapZeroTime().getText());

        }else {
            otherProtect.setHighGapZeroTime("-");
            otherProtect.setHighGapZeroCurrent("-");
        }

        if(putIn(transFrame.getMiddleGapZeroRation().getText())){
            int ration = Integer.parseInt(transFrame.getMiddleGapZeroCurrent().getText());
            int current = Integer.parseInt(transFrame.getMiddleGapZeroCurrent().getText());
            int v = 100/ration*current;
            otherProtect.setMiddleGapZeroCurrent(String.valueOf(v));
            otherProtect.setMiddleGapZeroTime(transFrame.getMiddleGapZeroTime().getText());

        }else {
            otherProtect.setMiddleGapZeroTime("-");
            otherProtect.setMiddleGapZeroCurrent("-");
        }
        String s = (String) transFrame.getInnerOuter().getSelectedItem();
        assert s != null;
        if(s.equals("外接")){
            otherProtect.setZeroVoltage("180");
        }else if(s.equals("自产")){
            otherProtect.setZeroVoltage("120");
        }else{
            otherProtect.setZeroVoltage("-");
        }
        if(putIn(transFrame.getZeroVoltageTime().getText())){
            otherProtect.setZeroVoltageTime(transFrame.getZeroVoltageTime().getText());
        }else {
            otherProtect.setZeroVoltageTime("-");
        }

        try {
            TransMethod.text(title,equipment,mainProtect,mainProtectCal,HighReserve,HighZeroProtect,MiddleReserve,
                    MiddleZeroProtect,LowReserve,otherProtect);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private boolean putIn(String current){
        return current != null && !current.equals("") && isNumeric1(current);
    }

    private boolean isNumeric1(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            if (str.startsWith(".") || str.endsWith(".")){
                return false;
            }
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        return isNum.matches();
    }

}
