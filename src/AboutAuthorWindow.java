import javax.swing.*;

public class AboutAuthorWindow extends JFrame {

    AboutAuthorWindow() {
        setIconImage(new ImageIcon("image/pngwing.png").getImage());
        setTitle("About the author");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JLabel Image = new JLabel();
        Image.setIcon(new ImageIcon("image/author.png"));
        add(Image);
        pack();
    }
}