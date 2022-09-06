import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ScheduleApp implements ActionListener {
    public static JFrame ScheduleAppFrame = new JFrame();

    public static DefaultListModel<String> dlm1 = new DefaultListModel<>();
    public static DefaultListModel<String> dlm2 = new DefaultListModel<>();
    public static DefaultListModel<String> dlm3 = new DefaultListModel<>();
    public static DefaultListModel<String> dlm4 = new DefaultListModel<>();
    public static DefaultListModel<String> dlm5 = new DefaultListModel<>();
    public static DefaultListModel<String> dlm6 = new DefaultListModel<>();

    JMenuBar menu;
    JMenu FileMenu, AboutProgramMenu;
    JMenuItem SettingsItem, ExitItem,
            AboutAuthorItem, AboutProgramItem, CertificateItem;

    JLabel BackgroundLabel,
            MondayLabel, TuesdayLabel, WednesdayLabel,
            ThursdayLabel, FridayLabel, SaturdayLabel;

    public ScheduleApp() {
        ScheduleAppFrame.setTitle("Lessons schedule");
        ScheduleAppFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ScheduleAppFrame.setIconImage(new ImageIcon("image/pngwing.png").getImage());
        menu = new JMenuBar();
        FileMenu = new JMenu("File");
        AboutProgramMenu = new JMenu("About the program");

        SettingsItem = new JMenuItem("Settings");
        ExitItem = new JMenuItem("Exit");

        CertificateItem = new JMenuItem("Certificate");
        AboutAuthorItem = new JMenuItem("About the author");
        AboutProgramItem = new JMenuItem("About the program");

        SettingsItem.addActionListener(this);
        ExitItem.addActionListener(this);

        CertificateItem.addActionListener(this);
        AboutAuthorItem.addActionListener(this);
        AboutProgramItem.addActionListener(this);

        SettingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));

        CertificateItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        AboutAuthorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        AboutProgramItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));

        FileMenu.addSeparator();
        FileMenu.add(SettingsItem);
        FileMenu.addSeparator();
        FileMenu.add(ExitItem);
        FileMenu.addSeparator();

        menu.add(FileMenu);
        menu.add(AboutProgramMenu);

        ScheduleAppFrame.setJMenuBar(menu);

        AboutProgramMenu.addSeparator();
        AboutProgramMenu.add(CertificateItem);
        AboutProgramMenu.addSeparator();
        AboutProgramMenu.add(AboutAuthorItem);
        AboutProgramMenu.add(AboutProgramItem);
        AboutProgramMenu.addSeparator();

        JPanel contents = new JPanel();

        MondayLabel = new JLabel("Monday");
        TuesdayLabel = new JLabel("Tuesday");
        WednesdayLabel = new JLabel("Wednesday");
        ThursdayLabel = new JLabel("Thursday");
        FridayLabel = new JLabel("Friday");
        SaturdayLabel = new JLabel("Saturday");

        MondayLabel.setBounds(78, 18, 100, 35);
        TuesdayLabel.setBounds(236, 18, 100, 35);
        WednesdayLabel.setBounds(389, 18, 100, 35);
        ThursdayLabel.setBounds(87, 195, 100, 35);
        FridayLabel.setBounds(236, 195, 100, 35);
        SaturdayLabel.setBounds(389, 195, 100, 35);

        contents.add(MondayLabel);
        contents.add(TuesdayLabel);
        contents.add(WednesdayLabel);
        contents.add(ThursdayLabel);
        contents.add(FridayLabel);
        contents.add(SaturdayLabel);

        BackgroundLabel = new JLabel();
        BackgroundLabel.setIcon(new ImageIcon("image/bg.jpg"));
        BackgroundLabel.setBounds(0, 0, 525, 520);

        JButton settings = new JButton("Settings");
        settings.addActionListener(e -> new Settings());
        settings.setFocusable(false);

        DownloadLists();

        JList<String> list1 = new JList<>(dlm1);
        JList<String> list2 = new JList<>(dlm2);
        JList<String> list3 = new JList<>(dlm3);
        JList<String> list4 = new JList<>(dlm4);
        JList<String> list5 = new JList<>(dlm5);
        JList<String> list6 = new JList<>(dlm6);

        JScrollPane MondayJScrollPane = new JScrollPane(list1);
        JScrollPane TuesdayJScrollPane = new JScrollPane(list2);
        JScrollPane WednesdayJScrollPane = new JScrollPane(list3);
        JScrollPane ThursdayJScrollPane = new JScrollPane(list4);
        JScrollPane FridayJScrollPane = new JScrollPane(list5);
        JScrollPane SaturdayJScrollPane = new JScrollPane(list6);

        MondayJScrollPane.setBounds(50, 50, 125, 150);
        TuesdayJScrollPane.setBounds(200, 50, 125, 150);
        WednesdayJScrollPane.setBounds(350, 50, 125, 150);
        ThursdayJScrollPane.setBounds(50, 225, 125, 150);
        FridayJScrollPane.setBounds(200, 225, 125, 150);
        SaturdayJScrollPane.setBounds(350, 225, 125, 150);

        settings.setBounds(50, 400, 125, 35);

        contents.setLayout(null);

        contents.add(settings);

        contents.add(MondayJScrollPane);
        contents.add(TuesdayJScrollPane);
        contents.add(WednesdayJScrollPane);
        contents.add(ThursdayJScrollPane);
        contents.add(FridayJScrollPane);
        contents.add(SaturdayJScrollPane);

        contents.add(BackgroundLabel);

        ScheduleAppFrame.setContentPane(contents);

        ScheduleAppFrame.setSize(525, 520);
        ScheduleAppFrame.setVisible(true);
    }

    public static void DownloadLists() {
        Settings.ClearAll();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("file.txt"), StandardCharsets.UTF_8))) {
            String line;
            String[] args;
            int IndexList = 0, i, n;
            while ((line = br.readLine()) != null) {
                args = line.split("ᅠ");
                i = args.length;
                n = 0;
                while (i != 0) {
                    switch (IndexList) {
                        case 0 -> dlm1.addElement(args[n]);
                        case 1 -> dlm2.addElement(args[n]);
                        case 2 -> dlm3.addElement(args[n]);
                        case 3 -> dlm4.addElement(args[n]);
                        case 4 -> dlm5.addElement(args[n]);
                        case 5 -> dlm6.addElement(args[n]);
                    }
                    n++;
                    i--;
                }
                IndexList++;
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
        RemoveEmptyItem(dlm1);
        RemoveEmptyItem(dlm2);
        RemoveEmptyItem(dlm3);
        RemoveEmptyItem(dlm4);
        RemoveEmptyItem(dlm5);
        RemoveEmptyItem(dlm6);
    }

    public static void RemoveEmptyItem(DefaultListModel<String> ListModel) {
        for (int i = 0; i < ListModel.size(); i++)
            if (Objects.equals(ListModel.getElementAt(0), ""))
                ListModel.remove(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SettingsItem) new Settings();
        if (e.getSource() == ExitItem) System.exit(0);
        if (e.getSource() == CertificateItem) new CertificateWindow();
        if (e.getSource() == AboutAuthorItem) new AboutAuthorWindow();
        if (e.getSource() == AboutProgramItem) new AboutProgramWindow();
    }
}
