import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accountant_section extends JFrame{
    private JButton addStudentButton;
    private JButton viewStudentButton;
    private JButton updateStudentButton;
    private JButton logoutButton;
    private JPanel main_panel;
    public accountant_section(){
        setContentPane(main_panel);
        setSize(320,320);
        setTitle("Accountant section");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountant_login al=new accountant_login();
                dispose();
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add_student as=new add_student();
                dispose();
            }
        });

        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_student us=new update_student();
                dispose();
            }
        });
    }
}
