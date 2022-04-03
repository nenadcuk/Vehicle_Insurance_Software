import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

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

    // Constructor
    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
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

    public static void main(String[] args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance Company System");
        mainScreen.setBounds(0, 0, 1920, 1080);
    }

}