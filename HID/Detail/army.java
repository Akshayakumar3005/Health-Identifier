package Detail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class army implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton button, button1;
    public void main(String aad)throws Exception{
        JLabel label;
        String url = "jdbc:mysql://localhost:3306/work";
        String uname = "root";
        String pass = "Akshay3005@";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        String q = "select * from army";
        String q3 = " where aad = ";
        String query  = q  + q3 + aad;
        ResultSet rs = st.executeQuery(query);
        String sp = "";
        //System.out.println(n);
        while(rs.next()){
            String email = rs.getString("email");
            int eye = rs.getInt("eye");
            int age = rs.getInt("age");
            int h = rs.getInt("height");
            String name = rs.getString("name");
            int chest = rs.getInt("chest");
            int weight = rs.getInt("weight");
            if(age > 18 && eye > 50 && h > 151 && chest > 77 && weight > 50 ) {
                sp = name + " you're eligible to apply!";
                break;
            }
            else if(eye < 50){
                sp = name + " you are vision score is low please consult the doctor, your application cant be further processed! further details have been sent to "+email;
                break;
            }

            else if(h < 151){
                sp = name + " you are under heighted, minimum height required is 152 cms your application cant be further processed! further details have been sent to "+email;
                break;
            }
            else if(chest < 77){
                sp = name + " you are chest is under measured, minimum chest required is 77 cms your application cant be further processed! further details have been sent to "+email;
                break;
            }
            else if(weight < 50){
                sp = name + " you are under weight, minimum weight required is 50 kgs your application cant be further processed! further details have been sent to "+email;
                break;
            }
        }
        frame = new JFrame();
        label = new JLabel();
        panel = new JPanel();
        button = new JButton("back");
        button1 = new JButton("check again");
        button.setBounds(100, 80,80,25);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        label.setText(sp);
        panel.add(label);
        button.addActionListener(new army());
        button1.addActionListener(this);
        panel.add(button);
        panel.add(button1);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("army checking result");
        frame.pack();
        frame.setVisible(true);

        st.close();
        con.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.exit(0);
        }
        if(e.getSource() == button1){
            GUI k = new GUI();
            k.GUII();
        }
    }
}