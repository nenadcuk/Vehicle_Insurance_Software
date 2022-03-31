package Plan;

public class AllRisks extends Risk{

    @Override
    public float getPremium() {
        return 0.075f;
    }

    @Override
    public float getCoverage() {
        return 1f;
    }

    @Override
    public float getCeiling() {
        return 10;
    }

    public String[] allRisksCovered = {
            "Fire",
            "Robbery",
            "Transport",
            "Car Replacement",
            "Third-party Damage",
            "Vehicle Damage",
            "Driver Damage"
    };
}
