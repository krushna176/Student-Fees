import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class add_accountant extends JFrame{
    private JTextField name;
    private JTextField pass;
    private JTextField email;
    private JTextField contact;
    private JButton addAccountantButton;
    private JButton goBackButton;
    private JPanel main_panel;
    private JTextField uid;

    public add_accountant(){
        setContentPane(main_panel);
        setTitle("Add accountant");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin_section as=new admin_section();
                dispose();
            }
        });
        addAccountantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int Id=Integer.parseInt(id.getText());
                String Name=name.getText();
                String Pass=pass.getText();
                String Email=email.getText();
                String userid=uid.getText();
                int Contact=Integer.parseInt(contact.getText());
                try {
                    Connection con=connection.getCon();
                    String query="insert into accountant(Name,Password,Email,Contact,User_ID) values(?,?,?,?,?)";
                    PreparedStatement psmt=con.prepareStatement(query);
                    psmt.setString(1,Name);
                    psmt.setString(2,Pass);
                    psmt.setString(3,Email);
                    psmt.setInt(4,Contact);
                    psmt.setString(5,userid);
                    psmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Added Accountant");
                } catch (SQLException sqex){
                    JOptionPane.showMessageDialog(null,"User ID already exist");
                } catch (Exception ex){
                        JOptionPane.showMessageDialog(null,"Something went Wrong");
                }
            }
        });
    }
}
