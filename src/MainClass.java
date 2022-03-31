public class MainClass {
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


}
