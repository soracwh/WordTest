package transformer;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.policy.DynamicTableRenderPolicy;
import com.deepoove.poi.policy.TableRenderPolicy;
import entity.tans.ProtectTableData;
import entity.tans.ReserveProtect;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.util.List;

/**
 * @Author Sora Chen
 * @Date 2022/4/18 19:59
 * @Version 1.0
 */
public class ProtectTablePolicy extends DynamicTableRenderPolicy {

    int startRow = 1;
    @Override
    public void render(XWPFTable table, Object data) throws Exception {
        if (null == data) return;
        List<RowRenderData> protect = (List<RowRenderData>) data;
        if (protect.size()!=0) {
            table.removeRow(startRow);
            int index = startRow;
            for (RowRenderData rowRenderData : protect) {
                XWPFTableRow insertNewTableRow = table.insertNewTableRow(index);
                for (int j = 0; j < 6; j++) insertNewTableRow.createCell();
                TableRenderPolicy.Helper.renderRow(table.getRow(index), rowRenderData);
                index++;
            }
        }
    }
}
