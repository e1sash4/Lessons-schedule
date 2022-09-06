import javax.swing.*;

public class AboutProgramWindow extends JFrame {

    AboutProgramWindow() {

        setIconImage(new ImageIcon("image/pngwing.png").getImage());
        setTitle("About the program");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JLabel Image = new JLabel();
        Image.setIcon(new ImageIcon("image/program.png"));
        add(Image);
        pack();
    }
}
