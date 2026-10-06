import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

class Student {
    private int id;
    private String name;
    private String stream;
    private String sec;

    public Student(int id, String name, String stream, String sec) {
        this.setId(id);
        this.setName(name);
        this.setStream(stream);
        this.setSec(sec);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }
}


class StudentView implements ActionListener {
    private static StudentController sc = new StudentController();

    JFrame frame1;
    JFrame frame2;
    JFrame frame3;

    String BACK = "BACK";
    String STORE = "STORE";
    String SHOW = "SHOW";
    String CREATE = "CREATE";
    String SEARCH = "SEARCH";

    JTextField iddata;
    JTextField namedata;
    JTextField streamdata;
    JTextField secdata;

    JTextField idv;

    JTextArea result2;
    JTextArea result3;

    public StudentView() {
        frame1 = new JFrame("Home");
        frame1.setSize(600, 600);
        frame1.setLayout(new FlowLayout());
        frame1.addWindowListener(new WindowAdapter() {
            void closingWindow() {
                System.exit(0);
            }
        });

        frame2 = new JFrame("Form");
        frame2.setSize(600, 600);
        frame2.setLayout(new FlowLayout());
        frame2.addWindowListener(new WindowAdapter() {
            void closingWindow() {
                System.exit(0);
            }
        });

        frame3 = new JFrame("Dashboard");
        frame3.setSize(600, 600);
        frame3.setLayout(new FlowLayout());
        frame3.addWindowListener(new WindowAdapter() {
            void closingWindow() {
                System.exit(0);
            }
        });

        JButton back1 = new JButton("Back");
        back1.addActionListener(this);
        back1.setActionCommand(BACK);

        JButton back2 = new JButton("Back");
        back2.addActionListener(this);
        back2.setActionCommand(BACK);

        JButton store = new JButton("Store New Student");
        store.addActionListener(this);
        store.setActionCommand(STORE);

        JButton show = new JButton("Show Exsisted Student");
        show.addActionListener(this);
        show.setActionCommand(SHOW);


        frame3.add(back2);
        frame2.add(back1);

        frame1.add(store);
        frame1.add(show);

        frame1.setVisible(true);


        // frame 2 form
        JLabel idlbl = new JLabel("Id: ");
        JLabel namelbl = new JLabel("Name: ");
        JLabel stramlbl = new JLabel("Stream: ");
        JLabel seclbl = new JLabel("Section: ");

        iddata = new JTextField(15);
        namedata = new JTextField(15);
        streamdata = new JTextField(15);
        secdata = new JTextField(15);

        JButton create = new JButton("Create New User");
        create.addActionListener(this);
        create.setActionCommand(CREATE);

        result2 = new JTextArea();

        frame2.add(idlbl);
        frame2.add(iddata);
        frame2.add(namelbl);
        frame2.add(namedata);
        frame2.add(stramlbl);
        frame2.add(streamdata);
        frame2.add(seclbl);
        frame2.add(secdata);
        frame2.add(create);
        frame2.add(result2);

        // frame 3 form
        JLabel lbl = new JLabel("Id: ");
        idv = new JTextField(15);
        
        JButton search = new JButton("Search By The Id");
        search.addActionListener(this);
        search.setActionCommand(SEARCH);

        result3 = new JTextArea();
        
        frame3.add(lbl);
        frame3.add(idv);
        frame3.add(search);
        frame3.add(result3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(BACK)) {
            frame2.setVisible(false);
            frame3.setVisible(false);
            frame1.setVisible(true);
        }
        else if(e.getActionCommand().equals(STORE)) {
            frame1.setVisible(false);
            frame3.setVisible(false);
            frame2.setVisible(true);
        }
        else if(e.getActionCommand().equals(SHOW)) {
            frame1.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
        }
        else if(e.getActionCommand().equals(CREATE)) {
            try{
                iddata.setEnabled(false);
                namedata.setEnabled(false);
                streamdata.setEnabled(false);
                secdata.setEnabled(false);


                int id = Integer.parseInt(iddata.getText());
                String name = namedata.getText();
                String stream = streamdata.getText();
                String sec = secdata.getText();

                if(id <= 0 || name == null || stream == null || sec == null) {
                    result2.setText("Invalid informations to create a new student.");
                }
                else {
                    Student newStd = sc.createStudent(id, name, stream, sec);
                    if(newStd == null) 
                        result2.setText("Student creation failed.Check terminal");
                    else 
                        result2.setText("Student created successfully");
                }

            } catch(Exception e1) {
                result2.setText("Something went wrong");
            }
        }
        else if (e.getActionCommand().equals(SEARCH)) {
            try {
                int id = Integer.parseInt(idv.getText());
                Student st = sc.findById(id);

                if(st == null) {
                    result3.setText("Student not found.");
                }
                else {
                    result3.setText("Student found.\nName: " + st.getName() + "\nId: " + st.getId() +  "\nStream: " + st.getStream() + "\nSection: " + st.getSec());
                }
            } catch (Exception e2) {
                result3.setText("Something went wrong");
            }
        }
    }
}


class StudentController {
    List<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }


    Student createStudent (int id, String name, String stream, String sec) {
        Student alreadyHas = findById(id);

        if(alreadyHas != null) {
            System.out.println("Id already exists.");
            return null;
        }

        students.add(new Student(id, name, stream, sec));
        return students.getLast();
    }

    Student findById (int id) {
        Iterator itr = students.iterator();

        while(itr.hasNext()) {
            Student st = (Student) itr.next();
            if(st.getId() == id) return st;
        }

        return null;
    }
}


public class MVCDP {
    public static void main(String[] args) {
        new StudentView();
    }
}
