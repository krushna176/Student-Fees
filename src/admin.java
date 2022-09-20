import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class admin extends JFrame{
    private JTextField id;
    private JTextField pass;
    private JPanel main_panel;
    private JPanel id_panel;
    private JPanel pass_panel;
    private JButton button1;
    private JButton goBackButton;

    public admin(){
        setContentPane(main_panel);
        setTitle("welcome to Admin Section");
        setSize(320,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login lg=new login();
                dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uid=id.getText();
                String Pass=pass.getText();
                try {
                    Connection con=connection.getCon();
                    String query="select pass from admin where uid=\""+uid+"\"";
                    Statement stmt=con.createStatement();
                    ResultSet set=stmt.executeQuery(query);
                    if(!set.next()){
                        JOptionPane.showMessageDialog(null,"User doesn't Exist");
                    }else{
//                        System.out.println(set.getString(0));
                        String p=set.getString(1);
                        if (Pass.equals(p)){
                            admin_section as=new admin_section();
                            dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"Password Doesn't Match");
                        }
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }

            }
        });
    }
}
