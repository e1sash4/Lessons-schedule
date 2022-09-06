import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Settings extends JFrame {
    public static boolean SaveOrNot;
    JLabel BackgroundLabel,
            MondayLabel,TuesdayLabel,WednesdayLabel,
            ThursdayLabel,FridayLabel,SaturdayLabel;

    public static JTextField MondayTextField;
    public static JTextField TuesdayTextField;
    public static JTextField WednesdayTextField;
    public static JTextField ThursdayTextField;
    public static JTextField FridayTextField;
    public static JTextField SaturdayTextField;

    public Settings(){
        super("Налаштування");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { ClosingSettingsWindow(); }
        });
        setIconImage(new ImageIcon("image/pngwing.png").getImage());

        SaveOrNot = true;

        JPanel contents = new JPanel();
        contents.setLayout(null);

        BackgroundLabel = new JLabel();
        BackgroundLabel.setIcon(new ImageIcon("image/bg.jpg"));
        BackgroundLabel.setBounds(0, 0, 525, 650);

        MondayLabel = new JLabel("Понеділок");
        TuesdayLabel = new JLabel("Вівторок");
        WednesdayLabel = new JLabel("Середа");
        ThursdayLabel = new JLabel("Четвер");
        FridayLabel = new JLabel("П'ятниця");
        SaturdayLabel = new JLabel("Субота");

        MondayLabel.setBounds(78,18,100,35);
        TuesdayLabel.setBounds(236,18,100,35);
        WednesdayLabel.setBounds(389,18,100,35);
        ThursdayLabel.setBounds(87,270,100,35);
        FridayLabel.setBounds(236,270,100,35);
        SaturdayLabel.setBounds(389,270,100,35);

        contents.add(MondayLabel);
        contents.add(TuesdayLabel);
        contents.add(WednesdayLabel);
        contents.add(ThursdayLabel);
        contents.add(FridayLabel);
        contents.add(SaturdayLabel);

        JList<String> list1 = new JList<>(ScheduleApp.dlm1);
        JList<String> list2 = new JList<>(ScheduleApp.dlm2);
        JList<String> list3 = new JList<>(ScheduleApp.dlm3);
        JList<String> list4 = new JList<>(ScheduleApp.dlm4);
        JList<String> list5 = new JList<>(ScheduleApp.dlm5);
        JList<String> list6 = new JList<>(ScheduleApp.dlm6);

        JScrollPane MondayJScrollPane = new JScrollPane(list1);
        JScrollPane TuesdayJScrollPane = new JScrollPane(list2);
        JScrollPane WednesdayJScrollPane = new JScrollPane(list3);
        JScrollPane ThursdayJScrollPane = new JScrollPane(list4);
        JScrollPane FridayJScrollPane = new JScrollPane(list5);
        JScrollPane SaturdayJScrollPane = new JScrollPane(list6);

        MoveRowsInList(ScheduleApp.dlm1,list1);
        MoveRowsInList(ScheduleApp.dlm2,list2);
        MoveRowsInList(ScheduleApp.dlm3,list3);
        MoveRowsInList(ScheduleApp.dlm4,list4);
        MoveRowsInList(ScheduleApp.dlm5,list5);
        MoveRowsInList(ScheduleApp.dlm6,list6);

        MondayTextField = new JTextField(35);
        TuesdayTextField = new JTextField(35);
        WednesdayTextField = new JTextField(35);
        ThursdayTextField = new JTextField(35);
        FridayTextField = new JTextField(35);
        SaturdayTextField = new JTextField(35);

        MondayTextField.setBounds(50,210,75,25);
        TuesdayTextField.setBounds(200,210,75,25);
        WednesdayTextField.setBounds(350,210,75,25);
        ThursdayTextField.setBounds(50,465,75,25);
        FridayTextField.setBounds(200,465,75,25);
        SaturdayTextField.setBounds(350,465,75,25);

        contents.add(MondayTextField);
        contents.add(TuesdayTextField);
        contents.add(WednesdayTextField);
        contents.add(ThursdayTextField);
        contents.add(FridayTextField);
        contents.add(SaturdayTextField);

        JButton SaveButton = new JButton("Зберегти");
        JButton ClearAllButton = new JButton("Очистити все");
        JButton CloseButton = new JButton("Закрити");

        CloseButton.addActionListener(e -> ClosingSettingsWindow());
        ClearAllButton.addActionListener(e -> ClearAll());
        SaveButton.addActionListener(e -> {
            SaveOrNot = true;
            SaveList(ScheduleApp.dlm1,1);
            SaveList(ScheduleApp.dlm2,2);
            SaveList(ScheduleApp.dlm3,3);
            SaveList(ScheduleApp.dlm4,4);
            SaveList(ScheduleApp.dlm5,5);
            SaveList(ScheduleApp.dlm6,6);
        });

        ClearAllButton.setBounds(50,535,150,25);
        SaveButton.setBounds(210,535,100,25);
        CloseButton.setBounds(320,535,100,25);

        ClearAllButton.setFocusable(false);
        SaveButton.setFocusable(false);
        CloseButton.setFocusable(false);

        contents.add(ClearAllButton);
        contents.add(SaveButton);
        contents.add(CloseButton);

        JButton MondayButtonAdd = new JButton("+");
        JButton TuesdayButtonAdd = new JButton("+");
        JButton WednesdayButtonAdd = new JButton("+");
        JButton ThursdayButtonAdd = new JButton("+");
        JButton FridayButtonAdd = new JButton("+");
        JButton SaturdayButtonAdd = new JButton("+");

        MondayButtonAdd.setFocusable(false);
        TuesdayButtonAdd.setFocusable(false);
        WednesdayButtonAdd.setFocusable(false);
        ThursdayButtonAdd.setFocusable(false);
        FridayButtonAdd.setFocusable(false);
        SaturdayButtonAdd.setFocusable(false);

        MondayButtonAdd.setBounds(125,210,50,25);
        TuesdayButtonAdd.setBounds(275,210,50,25);
        WednesdayButtonAdd.setBounds(425,210,50,25);
        ThursdayButtonAdd.setBounds(125,465,50,25);
        FridayButtonAdd.setBounds(275,465,50,25);
        SaturdayButtonAdd.setBounds(425,465,50,25);

        MondayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm1,list1,MondayTextField));
        TuesdayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm2,list2,TuesdayTextField));
        WednesdayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm3,list3,WednesdayTextField));
        ThursdayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm4,list4,ThursdayTextField));
        FridayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm5,list5,FridayTextField));
        SaturdayButtonAdd.addActionListener(e -> AddInfoToList(ScheduleApp.dlm6,list6,SaturdayTextField));

        contents.add(MondayButtonAdd);
        contents.add(TuesdayButtonAdd);
        contents.add(WednesdayButtonAdd);
        contents.add(ThursdayButtonAdd);
        contents.add(FridayButtonAdd);
        contents.add(SaturdayButtonAdd);

        JButton MondayButtonDelete = new JButton("Видалити");
        JButton TuesdayButtonDelete = new JButton("Видалити");
        JButton WednesdayButtonDelete = new JButton("Видалити");
        JButton ThursdayButtonDelete = new JButton("Видалити");
        JButton FridayButtonDelete = new JButton("Видалити");
        JButton SaturdayButtonDelete = new JButton("Видалити");

        MondayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm1,list1));
        TuesdayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm2,list2));
        WednesdayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm3,list3));
        ThursdayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm4,list4));
        FridayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm5,list5));
        SaturdayButtonDelete.addActionListener(e -> RemoveInfoFromList(ScheduleApp.dlm6,list6));

        MondayButtonDelete.setBounds(50,245,125,25);
        TuesdayButtonDelete.setBounds(200,245,125,25);
        WednesdayButtonDelete.setBounds(350,245,125,25);
        ThursdayButtonDelete.setBounds(50,500,125,25);
        FridayButtonDelete.setBounds(200,500,125,25);
        SaturdayButtonDelete.setBounds(350,500,125,25);

        MondayButtonDelete.setFocusable(false);
        TuesdayButtonDelete.setFocusable(false);
        WednesdayButtonDelete.setFocusable(false);
        ThursdayButtonDelete.setFocusable(false);
        FridayButtonDelete.setFocusable(false);
        SaturdayButtonDelete.setFocusable(false);

        contents.add(MondayButtonDelete);
        contents.add(TuesdayButtonDelete);
        contents.add(WednesdayButtonDelete);
        contents.add(ThursdayButtonDelete);
        contents.add(FridayButtonDelete);
        contents.add(SaturdayButtonDelete);

        MondayJScrollPane.setBounds(50,50,125,150);
        TuesdayJScrollPane.setBounds(200,50,125,150);
        WednesdayJScrollPane.setBounds(350,50,125,150);
        ThursdayJScrollPane.setBounds(50,305,125,150);
        FridayJScrollPane.setBounds(200,305,125,150);
        SaturdayJScrollPane.setBounds(350,305,125,150);

        contents.add(MondayJScrollPane);
        contents.add(TuesdayJScrollPane);
        contents.add(WednesdayJScrollPane);
        contents.add(ThursdayJScrollPane);
        contents.add(FridayJScrollPane);
        contents.add(SaturdayJScrollPane);

        contents.add(BackgroundLabel);

        setContentPane(contents);

        setSize(541, 625);
        setVisible(true);
    }
    public void ClosingSettingsWindow(){
        if(SaveOrNot)
            dispose();
        else {
            if(JOptionPane.showConfirmDialog(this, "Ви не зберегли зміни в розкладі. Ви впевнені що хочете закрити налаштування?", "Попередження",JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
            {
                dispose();
                ScheduleApp.DownloadLists();
            }
        }
    }
    public static void MoveRowsInList(DefaultListModel<String> ListModel,JList<String> List){
        String[] Row = {"",""};
        int[] IndexRow = {0,0};
        List.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if(ListModel.size()!=0) {
                        IndexRow[0] = List.getSelectedIndex();
                        Row[0] = ListModel.getElementAt(IndexRow[0]);
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if(ListModel.size()!=0) {
                        IndexRow[1] = List.getSelectedIndex();
                        Row[1] = ListModel.getElementAt(IndexRow[1]);
                        if(IndexRow[0]!=IndexRow[1]) {
                            ListModel.remove(IndexRow[0]);
                            ListModel.add(IndexRow[0], Row[1]);
                            ListModel.remove(IndexRow[1]);
                            ListModel.add(IndexRow[1], Row[0]);
                            List.clearSelection();
                        }
                    }
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

    }
    public static void RemoveInfoFromList(DefaultListModel<String> ListModel, JList<String> List){
        if(List.getSelectedIndex()!=-1){
            SaveOrNot = false;
            ListModel.remove(List.getSelectedIndex());
        }
        else if(ListModel.size() > 0) {
            SaveOrNot = false;
            ListModel.remove(ListModel.size()-1);
        }
    }
    public void AddInfoToList(DefaultListModel<String> ListModel, JList<String> List, JTextField TextField){
        if(List.getSelectedIndex()!=-1 && !Objects.equals(TextField.getText().trim(), "")){
            SaveOrNot = false;
            ListModel.add(List.getSelectedIndex(), TextField.getText().trim());
        }
        else if(!Objects.equals(TextField.getText().trim(), "")){
            SaveOrNot = false;
            ListModel.add(ListModel.getSize(), TextField.getText().trim());
        }
        List.clearSelection();
        TextField.setText("");

        validate();
    }
    public static void SaveList(DefaultListModel<String> list, int IndexList) {
        BufferedWriter writer;
        String[] ArrayWords = new String[list.size()];
        int i = 0;
        while(list.size() != i) {
            ArrayWords[i] = list.get(i);
            i++;
        }
        try {
            i = 0;
            if (IndexList == 1) {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt"), StandardCharsets.UTF_8));
                while (i != ArrayWords.length) {
                    writer.write(ArrayWords[i] + "ᅠ");
                    i++;
                }
            } else {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt",true), StandardCharsets.UTF_8));
                writer.append("\r\n");
                while (i != ArrayWords.length) {
                    writer.append(ArrayWords[i]).append("ᅠ");
                    i++;
                }
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void ClearAll(){
        if(ScheduleApp.dlm1.size()+ScheduleApp.dlm2.size()+ScheduleApp.dlm3.size()+
                ScheduleApp.dlm4.size()+ScheduleApp.dlm5.size()+ScheduleApp.dlm6.size() > 0){
            SaveOrNot = false;
            ScheduleApp.dlm1.removeAllElements();
            ScheduleApp.dlm2.removeAllElements();
            ScheduleApp.dlm3.removeAllElements();
            ScheduleApp.dlm4.removeAllElements();
            ScheduleApp.dlm5.removeAllElements();
            ScheduleApp.dlm6.removeAllElements();

            Settings.MondayTextField.setText("");
            Settings.TuesdayTextField.setText("");
            Settings.WednesdayTextField.setText("");
            Settings.ThursdayTextField.setText("");
            Settings.FridayTextField.setText("");
            Settings.SaturdayTextField.setText("");
        }
    }
}
