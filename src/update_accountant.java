import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class update_accountant extends JFrame{
    private JTable table1;
    private JTextField remove;
    private JButton searchButton;
    private JComboBox search;
    private JButton showAllButton;
    private JTextField password;
    private JTextField email;
    private JTextField contact;
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel main_panel;
    private JTextField userid;
    private JTextField nme;
    private JButton goBackButton;

    public void add(String query){
        try {
            DefaultTableModel model=(DefaultTableModel)table1.getModel();
            Connection con = connection.getCon();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);
            ResultSetMetaData rsmt=set.getMetaData();
            int cols=rsmt.getColumnCount();
            String[] colName=new String[cols];
            for (int i=0;i<cols;i++){
                colName[i]=rsmt.getColumnName(i+1);
            }
            model.setColumnIdentifiers(colName);
            String id, name, pass, email, cont,uid;
            if(!set.next())
                JOptionPane.showMessageDialog(null,"Doesn't Exist");
            else {
                do {
                    id = set.getString(1);
                    name = set.getString(2);
                    pass = set.getString(3);
                    email = set.getString(4);
                    cont = set.getString(5);
                    uid=set.getString(6);
                    String[] row = {id, name, pass, email, cont,uid};
                    model.addRow(row);
                }while (set.next());
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }
     public int id;
    public update_accountant(){
        setContentPane(main_panel);
        setSize(600,600);
        setTitle("View Accountant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel model=(DefaultTableModel)table1.getModel();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String srch = (String) search.getItemAt(search.getSelectedIndex());
                String query = "select * from accountant where " + srch + "=\"" + remove.getText() + "\"";
                add(query);

            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String query="select * from accountant";
                add(query);
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin_section as=new admin_section();
                dispose();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRowIndex = table1.getSelectedRow();
                id= Integer.parseInt(model.getValueAt(selectedRowIndex,0).toString());
                nme.setText(model.getValueAt(selectedRowIndex, 1).toString());
                password.setText(model.getValueAt(selectedRowIndex, 2).toString());
                email.setText(model.getValueAt(selectedRowIndex, 3).toString());
                contact.setText(model.getValueAt(selectedRowIndex, 4).toString());
                userid.setText(model.getValueAt(selectedRowIndex, 5).toString());
            }
        });
//        System.out.println(id);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt=JOptionPane.showConfirmDialog(null, "Do want to delete it!!","Alert",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if(opt==0) {
                    try {
                        Connection con = connection.getCon();
                        String query = "delete from accountant where ID=" + id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Deleted");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Something went wrong");
                    }
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt=JOptionPane.showConfirmDialog(null,"Confirm Updation","Update",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if(opt==0){
                    String name=nme.getText();
                    String mail=email.getText();
                    String pass=password.getText();
                    int cont= Integer.parseInt(contact.getText());
                    String user=userid.getText();
                    try {
                        Connection con=connection.getCon();
                        String query="update accountant set Name=?,Password=?,Email=?,Contact=?,User_Id=? where ID="+id;
                        PreparedStatement psmt=con.prepareStatement(query);
                        psmt.setString(1,name);
                        psmt.setString(2,pass);
                        psmt.setString(3,mail);
                        psmt.setInt(4,cont);
                        psmt.setString(5,user);
                        psmt.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Updated successfully");
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,"Something went wrong");
                    }
                }
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        String comp[]={"Name","User_Id","Email"};
        search=new JComboBox(comp);
//        search.setBounds(90,50,90,20);
    }
}
