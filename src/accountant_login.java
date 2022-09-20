import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class accountant_login extends JFrame{
    private JTextField uid;
    private JTextField pass;
    private JButton loginButton;
    private JButton goBackButton;
    private JPanel main_panel;

    public accountant_login(){
        setContentPane(main_panel);
        setSize(320,320);
        setTitle("Accountant Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login lg=new login();
                dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user=uid.getText();
                String Pass=pass.getText();
                try {
                    Connection con = connection.getCon();
                    String query="select Password from accountant where User_Id=\""+user+"\"";
                    Statement stmt=con.createStatement();
                    ResultSet set=stmt.executeQuery(query);
                    if(!set.next()){
                        JOptionPane.showMessageDialog(null,"User doesn't Exist");
                    }else{
//                        System.out.println(set.getString(1));
                        String p=set.getString(1);
                        if (Pass.equals(p)){
                            accountant_section as=new accountant_section();
                            dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"Password Doesn't Match");
                        }
                    }

                }catch (Exception ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }
            }
        });

    }
}
