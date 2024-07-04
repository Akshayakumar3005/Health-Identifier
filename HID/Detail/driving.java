package Detail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class driving implements ActionListener{
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
        String q = "select * from driving";
        String q3 = " where aad=";
        String query  = q  + q3 + aad;
        ResultSet rs = st.executeQuery(query);

        String sp = "";
        while(rs.next()){
            String a = rs.getString("name");
            System.out.println(a);
            int b = rs.getInt("age");
            int c  = rs.getInt("eye");
            String email = rs.getString("email");
            if(b > 17 && c > 34){
                sp = a + " you're eligible to drive!";
            }
            else if(c < 34){
                sp = a + " your vision score is less! Please consult an doctor your application can't be processed."+email;
                break;
            }
            else if(b < 18){
                int e = 18 - b;
                sp = a + " you have not reached 18 yet! Your application can't be processed further.";
                break;
            }
        }
        frame = new JFrame();
        label = new JLabel();
        panel = new JPanel();
        button = new JButton("exit");
        button1 = new JButton("check again");
        button.setBounds(100, 80,80,25);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        label.setText(sp);
        panel.add(label);
        button.addActionListener(new driving());
        button1.addActionListener(this);
        panel.add(button);
        panel.add(button1);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("driving license result");
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

