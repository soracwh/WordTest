
import service.TransFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Sora Chen
 * @Date 2022/3/23 19:22
 * @Version 1.0
 */

public class GetNewWord {
    
    public void init(){
        JFrame frame=new JFrame("自动继保试验报告生成器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,100,380,160);
        frame.setResizable(false);
        JPanel jPanel=new JPanel();
        jPanel.setBackground(Color.white);
        jPanel.setLayout(null);
        frame.add(jPanel);
        JLabel label = new JLabel("请选择你需要生成的报告类型");
        //设置字体颜色
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setForeground(Color.decode("#28b7c9"));
        label.setBounds(60,10,300,50);
        JButton button1 = new JButton("线路保护");
        button1.setBounds(20,60,100,30);
        JButton button2 = new JButton("主变保护");
        button2.setBounds(140,60,100,30);
        JButton button3 = new JButton("母差保护");
        button3.setBounds(260,60,100,30);
        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(label);
        //解决无法正确显示窗口内的组件
        frame.setVisible(false);
        frame.setVisible(true);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransFrame();
            }
        });
    }

    public static void main(String[] args) {
        new GetNewWord().init();
    }


}
