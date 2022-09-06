import javax.swing.*;

public class CertificateWindow extends JFrame {

    CertificateWindow() {
        setIconImage(new ImageIcon("image/pngwing.png").getImage());
        setTitle("Certificate");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JLabel Image = new JLabel();
        Image.setIcon(new ImageIcon("image/cert.png"));
        add(Image);
        pack();
    }
}