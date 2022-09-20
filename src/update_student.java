import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class update_student extends JFrame{
    private JPanel main_panel;
    private JTextField textField1;
    private JButton searchButton;
    private JButton goBackButton;
    private JTextField roll;
    private JTextField nme;
    private JTextField course;
    private JTextField mail;
    private JTextField fees;
    private JTextField pay;
    private JTextField due;
    private JTextField adr;
    private JTextField cty;
    private JTextField stt;
    private JTextField cntry;
    private JTextField cntct;
    private JPanel main;
    private JButton updateButton;
    private JButton wantToUpdateButton;

    public update_student() {
        setContentPane(main);
        setSize(320,600);
        setTitle("Update Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        wantToUpdateButton.setVisible(false);
        updateButton.setVisible(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Enter the roll number");
                else {
                    try {
                        int rno=Integer.parseInt(textField1.getText());
                        String r= String.valueOf(rno);

                        Connection con=connection.getCon();
                        String query="select * from student where RollNo="+r;
                        Statement stmt=con.createStatement();
                        ResultSet set=stmt.executeQuery(query);

                        if(!set.next())
                            JOptionPane.showMessageDialog(null,"Roll number doesn't exist");
                        else {
//                            System.out.println(set.getString(1));
//                            while (set.next()) {

                                roll.setText(set.getString(1));
                                nme.setText(set.getString(2));
                                course.setText(set.getString(3));
                                mail.setText(set.getString(4));
                                fees.setText(set.getString(5));
                                pay.setText(set.getString(6));
                                due.setText(set.getString(7));
                                adr.setText(set.getString(8));
                                cty.setText(set.getString(9));
                                stt.setText(set.getString(10));
                                cntry.setText(set.getString(11));
                                cntct.setText(set.getString(12));
                            }
                        roll.setEditable(false);
                        nme.setEditable(false);
                        course.setEditable(false);
                        mail.setEditable(false);
                        fees.setEditable(false);
                        pay.setEditable(false);
                        due.setEditable(false);
                        adr.setEditable(false);
                        cty.setEditable(false);
                        stt.setEditable(false);
                        cntry.setEditable(false);
                        cntct.setEditable(false);
                        updateButton.setVisible(false);
                        wantToUpdateButton.setVisible(true);
//                        }
                    }catch (Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"Something went wrong");
                    }
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountant_section as=new accountant_section();
                dispose();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rno= Integer.parseInt(roll.getText());
                String name=nme.getText();
                String corse=course.getText();
                String email=mail.getText();
                float fee= Float.parseFloat(fees.getText());
                float paid= Float.parseFloat(pay.getText());
                float Due= Float.parseFloat(due.getText());
                String add=adr.getText();
                String city=cty.getText();
                String state=stt.getText();
                String  country=cntry.getText();
                int contact=Integer.parseInt(cntct.getText());
                int a= Integer.parseInt(textField1.getText());
                try {
                    Connection con =connection.getCon();
                    String query="update student set RollNo=?,Name=?,Course=?,Email=?,Fee=?,Paid=?,Due=?,Address=?,City=?,State=?,Country=?,Contact=? where RollNo="+a;
                    PreparedStatement psmt=con.prepareStatement(query);
                    psmt.setInt(1,rno);
                    psmt.setString(2,name);
                    psmt.setString(3,corse);
                    psmt.setString(4,email);
                    psmt.setFloat(5,fee);
                    psmt.setFloat(6,paid);
                    psmt.setFloat(7,Due);
                    psmt.setString(8,add);
                    psmt.setString(9,city);
                    psmt.setString(10,state);
                    psmt.setString(11,country);
                    psmt.setInt(12,contact);
                    psmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data updated");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }
            }
        });
        wantToUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roll.setEditable(true);
                nme.setEditable(true);
                course.setEditable(true);
                mail.setEditable(true);
                fees.setEditable(true);
                pay.setEditable(true);
                due.setEditable(true);
                adr.setEditable(true);
                cty.setEditable(true);
                stt.setEditable(true);
                cntry.setEditable(true);
                cntct.setEditable(true);
                updateButton.setVisible(true);
            }
        });
    }
}
