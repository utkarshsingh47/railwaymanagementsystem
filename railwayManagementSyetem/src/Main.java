import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

// building ticket booking system
//what we need
//    person name email mob no source destiny date of journy birth coach seat no dob gender
public class Main {
    public static void main(String[] args) {
//        create JFrame to design frame
        JFrame frame=new JFrame("Railway Ticket Booking");
//       to provideframe size
//        to display the lables and text field
        JLabel namelb = new JLabel("Name: ");
        JTextField nametf = new JTextField();

        JLabel emaillb = new JLabel("Email: ");
        JTextField emailtf = new JTextField();

        JLabel mobnolb = new JLabel("Mobile No: ");
        JTextField mobnotf = new JTextField();

        JLabel sourcelb = new JLabel("Start Station: ");
        JTextField sourcetf = new JTextField();

        JLabel destlb = new JLabel("Destination Station: ");
        JTextField desttf = new JTextField();

        JLabel dojlb = new JLabel("Date of Journy: ");
        JTextField dojtf = new JTextField();

        JLabel birtfpreflb = new JLabel("Birth Preference: ");
        JTextField birtfpreftf = new JTextField();

        JLabel coachlb = new JLabel("Coach No: ");
        JTextField coachltf= new JTextField();

        JLabel seatnolb = new JLabel("Seat No: ");
        JTextField seatnotf = new JTextField();

        JLabel agelb = new JLabel("Age: ");
        JTextField ageltf= new JTextField();

        JLabel trainnamelb = new JLabel("Train Name: ");
        JTextField trainnametf = new JTextField();

        JLabel genderlb = new JLabel("Gender: ");
        JTextField gendertf = new JTextField();

        JLabel bookingid = new JLabel();


        JButton bookTicketBtn= new JButton("Book Now");
        JButton cancelbtn= new JButton("Cancel Button");
        JButton clearbtn= new JButton("Clear");
// set size of components and position in the frame
        namelb.setBounds(20,30,100,30);
        nametf.setBounds(120,30,150,30);
        emaillb.setBounds(20,70,100,30);
        emailtf.setBounds(120,70,150,30);
        mobnolb.setBounds(20,110,100,30);
        mobnotf.setBounds(120,110,150,30);
        agelb.setBounds(20,150,100,30);
        ageltf.setBounds(120,150,150,30);
        genderlb.setBounds(20,190,100,30);
        gendertf.setBounds(120,190,150,30);
        trainnamelb.setBounds(20,230,100,30);
        trainnametf.setBounds(120,230,150,30);
        



        sourcelb.setBounds(300,30,150,30);
        sourcetf.setBounds(450,30,150,30);
        destlb.setBounds(300,70,150,30);
        desttf.setBounds(450,70,150,30);
        dojlb.setBounds(300,110,150,30);
        dojtf.setBounds(450,110,150,30);

        birtfpreflb.setBounds(300,150,150,30);
        birtfpreftf.setBounds(450,150,150,30);
        coachlb.setBounds(300,190,100,30);
        coachltf.setBounds(450,190,150,30);
        seatnolb.setBounds(300,230,100,30);
        seatnotf.setBounds(450,230,150,30);
//        to add booking id
        bookingid.setBounds(50,300,450,30);
//to add button
        bookTicketBtn.setBounds(100,350,120,30);
        cancelbtn.setBounds(250,350,120,30);
        clearbtn.setBounds(400,350,120,30);


//        to add components on frame
        frame.add(namelb);
        frame.add(nametf);
        frame.add(emaillb);
        frame.add(emailtf);
        frame.add(mobnolb);
        frame.add(mobnotf);
        frame.add(sourcelb);
        frame.add(sourcetf);
        frame.add(destlb);
        frame.add(desttf);
        frame.add(dojlb);
        frame.add(dojtf);
        frame.add(agelb);
        frame.add(ageltf);
        frame.add(genderlb);
        frame.add(gendertf);
        frame.add(birtfpreflb);
        frame.add(birtfpreftf);
        frame.add(coachlb);
        frame.add(coachltf);
        frame.add(seatnolb);
        frame.add(seatnotf);
        frame.add(trainnamelb);
        frame.add(trainnametf);
        frame.add(bookTicketBtn);
        frame.add(cancelbtn);
        frame.add(clearbtn);
        frame.add(bookingid);

clearbtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Clear button clicked!");
        nametf.setText("");
        emailtf.setText("");
        mobnotf.setText("");
        sourcetf.setText("");
        desttf.setText("");
        dojtf.setText("");
        ageltf.setText("");
        gendertf.setText("");
        birtfpreftf.setText("");
        coachltf.setText("");
        seatnotf.setText("");
        trainnametf.setText("");

    }
});
//for exit btn
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

//    for book btn
        bookTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add the validation of form can't be empty
                if (nametf.getText().toString().isEmpty() ||
                        emailtf.getText().toString().isEmpty() ||
                        mobnotf.getText().toString().isEmpty() ||
                        gendertf.getText().toString().isEmpty() ||
                        sourcetf.getText().toString().isEmpty() ||
                        desttf.getText().toString().isEmpty() ||
                        dojtf.getText().toString().isEmpty() ||
                        ageltf.getText().toString().isEmpty() ||
                        seatnotf.getText().toString().isEmpty() ||
                        birtfpreftf.getText().toString().isEmpty() ||
                        coachltf.getText().toString().isEmpty() ||
                        trainnametf.getText().toString().isEmpty())

                {
                    bookingid.setText("Please fill the details");
                }
                else {
                    String url="jdbc:mysql://localhost:3306/railwaymanagementsyatem";
                    String username = "root";
                    String password = "";
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        String sql = "insert into bookinginfo"
                                + " values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString (1, nametf.getText().toString());
                        preparedStmt.setString (2, emailtf.getText().toString());
                        preparedStmt.setString   (3, mobnotf.getText().toString());
                        preparedStmt.setString(4, gendertf.getText().toString());
                        preparedStmt.setString    (5, sourcetf.getText().toString());
                        preparedStmt.setString    (6, desttf.getText().toString());
                        preparedStmt.setString    (7, dojtf.getText().toString());
                        preparedStmt.setString    (8, ageltf.getText().toString());
                        preparedStmt.setString    (9, seatnotf.getText().toString());
                        preparedStmt.setString    (10, birtfpreftf.getText().toString());
                        preparedStmt.setString    (11, coachltf.getText().toString());
                        preparedStmt.setString    (12, trainnametf.getText().toString());
                        preparedStmt.execute();
                        System.out.println("Db connected");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex+ "not Connected");
                    } 

                    Random random = new Random();
                    int id = random.nextInt(999999);
                    bookingid.setText("Your booking is confirmed and bookind id " + id);
                }


            }
        });

        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(630, 450);
        frame.setVisible(true);
    }
}




