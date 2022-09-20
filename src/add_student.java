import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class add_student extends JFrame{
    private JTextField rno;
    private JTextField course;
    private JTextField email;
    private JTextField fees;
    private JTextField paid;
    private JTextField due;
    private JTextArea address;
    private JTextField city;
    private JTextField country;
    private JTextField contact;
    private JButton ADDButton;
    private JPanel main_panel;
    private JButton goBackButton;
    private JTextField nme;
    private JTextField state;

    public add_student(){
        setContentPane(main_panel);
        setTitle("Add Student");
        setSize(320,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountant_section as=new accountant_section();
                dispose();
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rlno=Integer.parseInt(rno.getText());
                String Name=nme.getText();
                String Course=course.getText();
                String Email=email.getText();
                float Fee=Float.parseFloat(fees.getText());
                float Paid=Float.parseFloat(paid.getText());
                float Due=Float.parseFloat(due.getText());
                String Address=address.getText();
                String City=city.getText();
                String State=state.getText();
                String Country=country.getText();
                int Contact=Integer.parseInt(contact.getText());
                try {
                    Connection con=connection.getCon();
                    String query="insert into student(RollNo,Name,Course,Email,Fee,Paid,Due,Address,City,State,Country,Contact) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psmt=con.prepareStatement(query);
                    psmt.setInt(1,rlno);
                    psmt.setString(2,Name);
                    psmt.setString(3,Course);
                    psmt.setString(4,Email);
                    psmt.setFloat(5,Fee);
                    psmt.setFloat(6,Paid);
                    psmt.setFloat(7,Due);
                    psmt.setString(8,Address);
                    psmt.setString(9,City);
                    psmt.setString(10,State);
                    psmt.setString(11,Country);
                    psmt.setInt(12,Contact);
                    psmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Added successfully");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }

            }
        });
    }
}
