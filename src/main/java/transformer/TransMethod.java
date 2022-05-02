package transformer;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import entity.tans.*;
import util.Trans.TransRandomUtil;

import java.io.IOException;
import java.util.*;

/**
 * @Author Sora Chen
 * @Date 2022/4/8 22:07
 * @Version 1.0
 */
public class TransMethod {
    public static String resource_tran = "src/test/resources/transformer_tradition.docx";
    public static String resource_intel = "src/test/resources/transformer_intelligence.docx";

    public static void text(Title title, Equipment equipment, MainProtect mainProtect, MainProtectCal mainProtectCal,
                            List<ReserveProtect> HighReserve,List<ReserveProtect> HighZeroProtect,List<ReserveProtect> MiddleReserve,
                            List<ReserveProtect> MiddleZeroProtect, List<ReserveProtect> LowReserve,OtherProtect otherProtect,String kind) throws IOException {

        Map<String, Object> data = new HashMap<>();
        data.put("title",title.toString());
        data.put("equipment",equipment);
        //逆变器
        data.put("source", TransRandomUtil.getSourceRandom());
        //voltage,current
        data.put("first",TransRandomUtil.getVORandom(1));
        data.put("second",TransRandomUtil.getVORandom(2));
        data.put("third",TransRandomUtil.getVORandom(3));
        data.put("forth",TransRandomUtil.getVORandom(4));
        data.put("fifth",TransRandomUtil.getVORandom(5));

        data.put("angle",TransRandomUtil.getAngleRandom());

        data.put("complexV",TransRandomUtil.getComplexVoltage());

        //纵差保护
        data.put("mainProtect",mainProtect);
        data.put("mainProtectCal",mainProtectCal);

        List<RowRenderData> HighPlaten = new ArrayList<>();
        List<RowRenderData> MiddlePlaten = new ArrayList<>();
        List<RowRenderData> LowPlaten = new ArrayList<>();
        List<RowRenderData> action = new ArrayList<>();
        //高复流
        data.put("protect_high",getRow(HighReserve,HighPlaten,action));
        //高零流
        data.put("zero_high",getRow(HighZeroProtect,HighPlaten,action));
        data.put("high_platen",HighPlaten);

        //中复流
        data.put("protect_middle",getRow(MiddleReserve,MiddlePlaten,action));
        //中零流
        data.put("zero_middle",getRow(MiddleZeroProtect,MiddlePlaten,action));
        data.put("middle_platen",MiddlePlaten);

        //低复流
        data.put("protect_low",getRow(LowReserve,LowPlaten,action));
        data.put("low_platen",LowPlaten);

        data.put("action_table",action);

        data.put("otherProtect",otherProtect);


        ConfigureBuilder builder = Configure.builder().useSpringEL().bind("protect_high",new ProtectTablePolicy())
                .bind("zero_high",new ProtectTablePolicy()).bind("protect_middle",new ProtectTablePolicy())
                .bind("zero_middle",new ProtectTablePolicy()).bind("protect_low",new ProtectTablePolicy())
                .bind("high_platen",new PlatenPolicy()).bind("middle_platen",new PlatenPolicy())
                .bind("low_platen",new PlatenPolicy()).bind("action_table",new ActionPolicy());
        String resource;
        String root = System.getProperty("user.dir");
        if(kind.equals("智能站")){
            resource = resource_intel;
            //resource = root+"/transformer_intelligence.docx";
        }else{
            resource = resource_tran;
            //resource = root+"/transformer_tradition.docx";
        }
        XWPFTemplate template = XWPFTemplate.compile(resource,builder.build()).render(data);
        template.writeToFile("target/"+title.toString()+".docx");
        //template.writeToFile(root+"/"+title.toString()+".docx");
    }

    private static List<RowRenderData> getRow(List<ReserveProtect> protect,List<RowRenderData> platen,List<RowRenderData> action){
        List<RowRenderData> res = new ArrayList<>();
        for (int i = 0; i< protect.size(); i++) {
            ReserveProtect reserveProtect = protect.get(i);
            RowRenderData row = Rows.of(reserveProtect.getName(), reserveProtect.getCurrent(),reserveProtect.getTime(),
                    TransRandomUtil.addTime(reserveProtect.getTime()), "动作","不动作").textFontSize(9).center().create();
            RowRenderData p = Rows.of(reserveProtect.getPlaten(),"正确"," ").textFontSize(9).center().create();
            RowRenderData a = Rows.of(String.valueOf(action.size()+2),reserveProtect.getName(),reserveProtect.getAction(),reserveProtect.getAction(),"正确").textFontSize(9).center().create();
            action.add(a);
            platen.add(p);
            res.add(row);
        }
        return res;
    }
}
