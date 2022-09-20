import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_section extends JFrame {
    private JPanel main_panel;
    private JButton addAccountantButton;
    private JButton viewAccountantButton;
    private JButton logOutButton;

    public admin_section() {

//        logOutButton.setBounds(120,200,200,35);
        setContentPane(main_panel);
        setSize(320,320);
        setTitle("Admin Section");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login lg=new login();
                dispose();
            }
        });
        addAccountantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add_accountant aa=new add_accountant();
                dispose();
            }
        });
        viewAccountantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_accountant va=new update_accountant();
                dispose();
            }
        });
    }

}
