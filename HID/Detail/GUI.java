package Detail;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends Component implements ActionListener {
    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel, panel1, panel2, panel3, panel4;
    JButton button1, button2, button3, button4, button5, button6;

    JLabel label1, label2, label3, label4;
    JFrame frame1, frame2, frame3;
    JTextField textField;
    public GUI(){ // menu
        frame = new JFrame();
        JButton button = new JButton("continue");
        button.addActionListener(this);
        label = new JLabel("Welcome to Health Identity Integrator!");
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Health Identity Integrator");
        frame.pack();
        frame.setVisible(true);
    }
    public void GUII(){ // choose between army and driving license
        frame1 = new JFrame();
        button1 = new JButton("Driving License");
        button2 = new JButton("Army");
        button5 = new JButton("exit");
        button1.addActionListener(this);
        label1 = new JLabel("which category you want to assess the candidate on?");
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel1.setLayout(new GridLayout(0, 1));
        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button5);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);


        frame1.add(panel1, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Health Identity Integrator");
        frame1.pack();
        frame1.setVisible(true);
    }
    public void GUIII(){ // driving license
        frame2 = new JFrame();
        button3 = new JButton("enter");
        button4 = new JButton("Go Back");
        button5 = new JButton("exit");
        textField = new JTextField("only first 6 digits");
        textField.setBounds(100,20,165,25);
        label2 = new JLabel("enter first six digits of your aadhar number");
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0, 1));
        panel2.add(label2);
        panel2.add(textField);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);

        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Driving License");
        frame2.pack();
        frame2.setVisible(true);
    }

    public void GUIIII(){ // army
        frame3 = new JFrame();
        button6 = new JButton("enter");
        button4 = new JButton("Go Back");
        button5 = new JButton("exit");
        textField = new JTextField("only first 6 digits");
        textField.setPreferredSize(new Dimension(250,40));
        label3 = new JLabel("enter first six digits of your aadhar number");
        panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel3.setLayout(new GridLayout(0, 1));
        panel3.add(label3);
        panel3.add(textField);
        panel3.add(button6);
        panel3.add(button4);
        panel3.add(button5);
        button6.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);


        frame3.add(panel3, BorderLayout.CENTER);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Army");
        frame3.pack();
        frame3.setVisible(true);
    }


    public static void main(String[] args){
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUI s = new GUI();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.GUII();
        if(e.getSource() == button1){
            s.GUIII();

        }
        if(e.getSource() == button2){
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            s.GUIIII();
        }
        if(e.getSource() == button4){
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource() == button5){
            int response = JOptionPane.showConfirmDialog(this, "you're about to exit the program are you sure?", "EXIT", 
JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            else{
                GUI k = new GUI();
                k.GUII();
            }

        }
        if(e.getSource() == button3){ // driving license eligibilty checking button.
            String ip = textField.getText();
            driving dri = new driving();
            try {
                dri.main(ip);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }
        if(e.getSource() == button6){ // army eligibilty checking button.
            String ip = textField.getText();
            army arm = new army();
            try {
                arm.main(ip);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
