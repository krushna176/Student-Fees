import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JButton adminButton;
    private JButton accountantButton;
    private JPanel panel;

    public login() {
        setContentPane(panel);
        setTitle("Welcome");
        setSize(420,420);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin ad=new admin();
                dispose();

            }
        });
        accountantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountant_login al=new accountant_login();
                dispose();
            }
        });
    }
}
