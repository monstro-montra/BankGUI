import java.awt.*; //import awt
import java.awt.event.ActionListener; //import action listener
import java.awt.event.ActionEvent; //import action event
import javax.swing.*; //import Swing


public class BankGUI extends JFrame{
    //create instance variables
    private JFrame mainMenu = new JFrame();
    private JPanel loginPanel = new JPanel();
    private JPanel menuPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel displayPanel = new JPanel();
    private String firstName;
    private String lastName;
    private int accountID;
    private JLabel firstNameLabel, lastNameLabel, accountIDLabel;
    private JTextField firstNameField, lastNameField, accountIDField;
    private double balance = 1000;
    private JButton btn1 = new JButton("Deposit"); //deposit button
    private JButton btn2 = new JButton("Withdraw"); //withdraw button
    private JButton btn3 = new JButton("Display Account Information"); //account info button
    private JButton btn4 = new JButton("Exit"); //exit button
    private JButton Enter;
    private JPanel switcher = new JPanel(new CardLayout());
    final static String MENUPANEL = "Main Menu Panel";
    final static String LOGINPANEL = "Login Panel";
    
    
    
    //main method
    public static void main(String[] args){
        run();
        System.out.println("hello");
    }

    //static run method to run the all of the creation/setup methods. static so it can be passed on to main method 
    //without need for easily creating a new object in main
    public static void run(){
        BankGUI run = new BankGUI();
        run.createMenuFrame(); //runs createFrame method
        run.switcherSetup();
        run.login(); //runs login method which creates the login panel
        run.menu(); //runs menu method which creates the menuPanel
        run.setupButtons(); //runs setupButtons method
        run.displayLabels(); //runs displayLabels method
    }
    //method used to create the frame
    public void createMenuFrame(){ //step one
        mainMenu.getContentPane();
        final int P_WIDTH = 600; //set width to 600 pixels
        final int P_HEIGHT = 600; //set height to 600 pixels
        mainMenu.setSize(P_WIDTH, P_HEIGHT); //set size to P_WIDTH and P_HEIGHT respectively
        mainMenu.setTitle("Bank Account");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default close operation to exit on close
        mainMenu.setVisible(true); //set the frame to visible
    }

    public void switcherSetup(){ //step two
        mainMenu.add(switcher); //add the switcher panel
        switcher.setSize(600, 600);
        switcher.setVisible(true);
        //JLabel test = new JLabel("test");
        //switcher.add(test);
        switcher.add(loginPanel, LOGINPANEL); //add loginPanel to switcher panel with LOGINPANEL string constraint
        switcher.add(menuPanel, MENUPANEL); //add menuPanel to switcher panel with MENUPANEL string constraint
    }

    public void login(){ // step three
        //first name label and text field
        firstNameLabel = new JLabel();
        firstNameLabel.setText("First Name: ");
        firstNameField = new JTextField();

        //last name label
        lastNameLabel = new JLabel();
        lastNameLabel.setText("Last Name: ");
        lastNameField = new JTextField();

        //ID Label
        accountIDLabel = new JLabel();
        accountIDLabel.setText("Account ID: ");
        accountIDField = new JTextField();

        Enter = new JButton();
        loginPanel = new JPanel(new GridLayout(4,1));
        loginPanel.add(firstNameLabel);
        loginPanel.add(firstNameField);
        loginPanel.add(lastNameLabel);
        loginPanel.add(lastNameField);
        loginPanel.add(accountIDLabel);
        loginPanel.add(accountIDField);
        loginPanel.add(Enter);
        switcher.add(loginPanel);
    }


    //method used to create the main panel, display panel, and the button panel
    public void menu(){

        //set top left bottom and right borders of panel
        menuPanel.setBounds(0 ,0 , 600, 600); //the bounds are set in the form: x, y, width, height
        
        /*following linesets the jpanel layout to a grid layout in form rows, columns. setting up as two rows to 
        have two separate panels*/
        menuPanel.setLayout(new GridLayout(2,1)); 
        displayPanel.setBackground(Color.LIGHT_GRAY); //this will set the top panel to a light gray color to show separation

        menuPanel.add (displayPanel); //add the displayPanel to the menuPanel in row 1
        menuPanel.add(buttonPanel); // add buttonPanel to the menuPanel in row 2

        mainMenu.add(switcher);
    }       

    //method used to setup the buttons
    public void setupButtons(){
        //TODO btn1 deposit setup
        btn1.setSize(100, 20); //set the size of button: width, height
        btn1.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                 System.out.println("click!");
            }

        });
        buttonPanel.add(btn1);// add this button to the main menu panel

        //TODO btn2 withdraw setup
        btn2.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn2.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                 System.out.println("boom!");
            }

        });
        buttonPanel.add(btn2);// add this button to the main menu panel

        //TODO btn3 display account infosetup
        btn3.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn3.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                 System.out.println("wow!");
            }

        });
        buttonPanel.add(btn3);// add this button to the main menu panel

        //btn4 exit button setup
        btn4.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn4.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                 System.exit(0);
            }

        });
        buttonPanel.add(btn4);// add this button to the main menu panel
    }

    //method used to display labels
    public void displayLabels(){
        Component displayBalance = new JLabel("Balance: " + balance);
        displayPanel.add(displayBalance);
    }

}
