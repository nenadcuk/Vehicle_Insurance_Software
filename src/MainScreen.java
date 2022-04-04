import Policy.Customer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {
    /**This is an application for a vehicle insurance company.
     * The app must manage the information and operations applied in these types of companies:
        * Data entry
        * treatment
        * save/restore
        * use the company data
     * Entities:
        * Insurance policy: represents the contract between the customer and the company
                - Administrative info (number, date, terms...)
                - Entities involved in the policy (to be identified)
                - Premium (amount to be paid by the customer
                - Coverage (amount to be paid by the company in case of an accident
                - Insurance Plan (a well-defined risk coverage package)
            -(Premium and Coverage are based on the value of the vehicle and the type of insurance plan)

        * Insurance plan: defines one or more risks covered by the policy with coverage for each risk and
          the premium to be paid for this type of plan.
            - For each plan, the premium and coverage are given as percentages of the appreciated value of
              of the vehicle is $20,000, an all-risk plan will have a 7.5% premium and 100% coverage.
            - Every insurance plan will have a coverage ceiling from which the amount of each claim will be
              deducted. The driver's corporal injury coverage will have a ceiling limit (for example, $50,000
              to deduct the amount of each claim)
            - The driver's death coverage will have fixed coverage, for example $100,000.

        * Customer
            - Personal and functional information on the policyholder. A customer may hold multiple policies
              for the same car.
        * Vehicle
            * Vehicle registration information:
                - Administrative information for registering a vehicle (on the registration card)
                - Current value (appreciated by the company)
                - State of the vehicle: including an inventory of the damaged main parts
                -...
        * Claims
            - Administrative data: number, date...
            - Accident data or case data: date, type
            - A damaged inventory
            - A compensation amount (established according to the insurance plan)

        * Settlements
            - Customer payment of premiums to the company: the customer pays the premium in a
              single payment where he gets a receipt.
            - Settlement for third-party interventions by the company.
                - A settlement to third parties is made as a consequence of a claim. A claim can have multiple
                  settlements to different third parties. It must include:
                        - Administrative data: number, date, amount...
                        - Justifications for damage settled: parts to be replaced, labor fees, medical expenses...
                        - The destination of the settlement (to whom to pay)

        The treatment model:
            1. Data entry of information about the mentioned entities (customer, vehicle, policy, claim,
               settlement, insurance plans, risks...
            2. Possibility to search for a policy, claim, settlement...
            3. Processing and analyzing transactions, their deadlines, conditions and amounts
            4. Displaying document: policy, claim, settlement, inventories, receipts...**/

    // Customization
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subFName;
    JTextField subLName;
    JTextField subCity;
    JTextField subPhone;

    // Panel 2
    JTextField model;
    JTextField manufacturer;
    JTextField plateNo;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    // Panel 3
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assistCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();

    // Panel 4
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYEAR = 0;
    SimpleDateFormat df;
    Date currentDate;

    // Panel 5
    JTextArea risksTXTArea;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    // Panel 7
    JTextArea policyTXTArea;

    // Panel 8
    JTextArea customerTXTArea;

    // Panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;

    // Panel 10
    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL;
    JTextArea claimingCustomerRisksCoveredTXTArea;
    JLabel claimingCustomerValidDateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    // Panel 11
    JTextArea settlementsTXTArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    // Panel 12
    JTextArea settlementsTXTArea2;


    // Constructor
    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }

    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                "  Customer  ", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont, myColor);

        p1.setBorder(titledBorder);

        JLabel fNameLBL = new JLabel(" First Name");
        JLabel lNameLBL = new JLabel(" Last Name");
        JLabel cityLBL = new JLabel(" City");
        JLabel phoneLBL = new JLabel(" Phone");

        subFName = new JTextField();      subFName.setOpaque(false);
        subLName = new JTextField();      subLName.setOpaque(false);
        subCity  = new JTextField();      subCity.setOpaque(false);
        subPhone = new JTextField();      subPhone.setOpaque(false);

        p1.add(fNameLBL);
        p1.add(subFName);
        p1.add(lNameLBL);
        p1.add(subLName);
        p1.add(cityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);

        p1.setBounds(15, 15, 300, 200);
        p1.setLayout(new GridLayout(4, 2));

        // Adding panels to JFrame
        setLayout(null);
        add(p1);
    }
    private void CustomizePanel2() {
        JPanel p2 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Vehicle  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p2.setBorder(titledBorder);

        // JLabels p2
        JLabel plateNoLBL = new JLabel(" Plate No");
        JLabel modelLBL = new JLabel(" Model Year");
        JLabel manufacturerLBL = new JLabel(" Manufacturer");
        JLabel estimatedLBL = new JLabel(" Estimated Value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel(" Major Damage");

        // JTextFields p2
        plateNo = new JTextField();            plateNo.setOpaque(false);
        model = new JTextField();              model.setOpaque(false);
        manufacturer = new JTextField();       manufacturer.setOpaque(false);
        estimated = new JTextField();          estimated.setOpaque(false);

        // Radio Buttons p2
        damageRadio1 = new JRadioButton();     damageRadio1.setText(" Engine");
        damageRadio2 = new JRadioButton();     damageRadio2.setText(" Wheels");
        damageRadio3 = new JRadioButton();     damageRadio3.setText(" Body");
        damageRadio4 = new JRadioButton();     damageRadio4.setText(" None");

        G1 = new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);

        // Adding components to p2
        p2.add(plateNoLBL);
        p2.add(plateNo);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

        // Customize p2
        p2.setBounds(15, 250, 300, 500);
        p2.setLayout(new GridLayout(14, 1));
        setLayout(null);
        add(p2);
    }
    private void CustomizePanel3() {
        JPanel p3 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Plan  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p3.setBorder(titledBorder);
        p3.setBounds(330, 15, 300, 200);
        p3.setLayout(new GridLayout(6, 1));

        JLabel packageLBL = new JLabel("Please Select your Plan");

        // Checkboxes
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risks");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assistCHKBX = new JCheckBox("Assistance");

        // Get all risks covered by plan
        GetRisksCoveredByPlan();

        // Adding components to p3
        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assistCHKBX);

        add(p3);
    }
    private void CustomizePanel4() {
        JPanel p4 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Validity Period  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p4.setBorder(titledBorder);
        p4.setBounds(330, 250, 300, 250);
        p4.setLayout(new GridLayout(6, 1));

        // Radio Buttons
        JLabel spacer2 = new JLabel(" ");        spacer2.setOpaque(false);
        yearRadio = new JRadioButton();
        yearRadio.setText(" 1 Year");
        yearRadio2 = new JRadioButton();
        yearRadio2.setText(" 2 Years");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText(" 3 Years");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 1;
            }
        });
        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR  = 3;
            }
        });


        // Button Group
        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);

        // Time & Date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont(font.deriveFont(size));

        // Adding all components to p4
        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);

        // Adding p4 to jFrame
        add(p4);

    }
    private void CustomizePanel5() {
        JPanel p5 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Actions  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p5.setBorder(titledBorder);
        p5.setBounds(330,520,300,230);
        p5.setLayout(new GridLayout(7, 1));

        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan Details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        JTextField searchTXT = new JTextField("Enter Car Plate No");
        searchTXT.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);

        add(p5);
    }
    private void CustomizePanel6() {
        JPanel p6 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Covered Risks  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p6.setBorder(titledBorder);
        p6.setBounds(645, 15, 300, 200);

        risksTXTArea = new JTextArea(7, 1);
        risksTXTArea.setEditable(false);
        risksTXTArea.setOpaque(false);
        risksTXTArea.setLineWrap(true);

        // Font
        Font font = risksTXTArea.getFont();
        float size = font.getSize() + 3.0f;
        risksTXTArea.setFont(font.deriveFont(size));

        p6.add(risksTXTArea);
        p6.setLayout(new GridLayout(1, 1));
        add(p6);
    }
    private void CustomizePanel7() {
        JPanel p7 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Policy Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p7.setBorder(titledBorder);
        p7.setBounds(645, 250, 300, 250);
        p7.setLayout(new GridLayout(6,1));

        policyTXTArea = new JTextArea(20,1);
        policyTXTArea.setEditable(false);
        policyTXTArea.setOpaque(false);
        policyTXTArea.setLineWrap(true);

        Font font = policyTXTArea.getFont();
        float size = font.getSize() + 3.0f;
        policyTXTArea.setFont(font.deriveFont(size));

        p7.add(policyTXTArea);
        p7.setLayout(new GridLayout(1, 1));
        add(p7);
    }
    private void CustomizePanel8() {
        JPanel p8 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Customer Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p8.setBorder(titledBorder);
        p8.setBounds(645,520,300,230);
        p8.setLayout(new GridLayout(6,1));

        customerTXTArea = new JTextArea(20,1);
        customerTXTArea.setEditable(false);
        customerTXTArea.setOpaque(false);
        customerTXTArea.setLineWrap(true);

        Font font = customerTXTArea.getFont();
        float size = font.getSize() + 3.0f;
        customerTXTArea.setFont(font.deriveFont(size));

        p8.add(customerTXTArea);
        p8.setLayout(new GridLayout(1,1));
        add(p8);
    }
    private void CustomizePanel9() {
        JPanel p9 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Claims  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p9.setBorder(titledBorder);
        p9.setBounds(960,15,300,485);

        claimingTXT = new JLabel("Enter Plate No. for the Claiming Customer");
        JLabel spacer7 = new JLabel("                                                        ");
        claimingTXT2 = new JLabel("Select the Type of Damage or Assistance Needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250, 30));
        claimingCustomerField.setOpaque(false);

        String[] items = { "Fire", "Robbery", "Third Party Damage", "Vehicle Damage",
                            "Driver Damage", "Transport", "Car Replacement"};

        final JList claimList = new JList<>(items);

        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setOpaque(false);
        claimList.setPreferredSize(new Dimension(250,150));

        JButton searchClaimer = new JButton("Search Claimer(Customer)");
        List<String> coveredRisksByUserLIST = new ArrayList<>();
        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton confirmClaimBTN = new JButton("  Confirm Claim  ");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer7);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);
        add(p9);

    }
    private void CustomizePanel10() {
        JPanel p10 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Claim Status  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p10.setBorder(titledBorder);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));

        claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLBL = new JLabel("Validity Date of Policy: ");
        claimStatusLBL = new JLabel("Claiming Status: ");

        claimingCustomerRisksCoveredTXTArea = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredTXTArea);
        claimingCustomerRisksCoveredTXTArea.setOpaque(false);

        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL);
        add(p10);

    }
    private void CustomizePanel11() {
        JPanel p11 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Payments  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p11.setBorder(titledBorder);
        p11.setBounds(1275,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementsTXTArea = new JTextArea();
        settlementsTXTArea.setOpaque(false);

        Font font = settlementsTXTArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementsTXTArea.setFont(font.deriveFont(size));

        p11.add(settlementsTXTArea);
        add(p11);
    }
    private void CustomizePanel12() {
        JPanel p12 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        "  Settlements  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementsTXTArea2 = new JTextArea();
        settlementsTXTArea2.setOpaque(false);

        Font font = settlementsTXTArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementsTXTArea.setFont(font.deriveFont(size));

        p12.add(settlementsTXTArea2);
        add(p12);
    }

    private void GetRisksCoveredByPlan() {
    }

    public static void main(String[] args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance Company System");
        mainScreen.setBounds(0, 0, 1920, 1080);
    }

}
