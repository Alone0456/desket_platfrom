package tyut.selab.desktop.ui.todolist.component;



import tyut.selab.desktop.ui.todolist.listener.ActionDoneListener;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class UpdateBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    private String id;
    private ActionDoneListener listener;
    private Map<String,Object> map;

    private JTextField nameField;
    private JTextField stockField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea descArea;

    public UpdateBookDialog(JFrame jf, String title, boolean isModel, ActionDoneListener listener,String id){
        super(jf,title,isModel);
        this.listener  = listener;
        this.id=id;
        //��װ��ͼ
        this.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);

        Box vBox = Box.createVerticalBox();

        //��װͼ������
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("ͼ�����ƣ�");
        nameField = new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        //��װͼ����
        Box stockBox = Box.createHorizontalBox();
        JLabel stockLable = new JLabel("ͼ���棺");
        stockField = new JTextField(15);

        stockBox.add(stockLable);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //��װͼ������
        Box authorBox = Box.createHorizontalBox();
        JLabel authorLable = new JLabel("ͼ�����ߣ�");
        authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //��װͼ��۸�
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLable = new JLabel("ͼ��۸�");
         priceField = new JTextField(15);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);


        //��װͼ����
        Box descBox = Box.createHorizontalBox();
        JLabel descLable = new JLabel("ͼ���飺");
        descArea = new JTextArea(3,15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(new JScrollPane(descArea));

        //��װ��ť
        Box btnBox = Box.createHorizontalBox();
        JButton updateBtn = new JButton("�޸�");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��ȡ�û��޸ĺ�������������������
                String name = nameField.getText().trim();
                String stock = stockField.getText().trim();
                String author = authorField.getText().trim();
                String price = priceField.getText().trim();
                String desc = descArea.getText().trim();

                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("description",desc);
                params.put("author",author);
                params.put("price",price);
                params.put("stock",stock);
                params.put("id",map.get("id").toString());
                //���ʺ�̨�ӿ�

            }
        });
        //TODO �����޸ĵ���Ϊ
        btnBox.add(updateBtn);

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(stockBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

        //Ϊ�������м�࣬��vBox����װһ��ˮƽ��Box����Ӽ��
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));

        this.add(hBox);
        //��������
        requestData();
    }

    //��������
    public void requestData(){

    }

}
