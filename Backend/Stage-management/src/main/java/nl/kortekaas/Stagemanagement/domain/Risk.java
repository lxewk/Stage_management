package nl.kortekaas.Stagemanagement.domain;

public class Risk {

    private String riskItemName;

    public Risk(String riskItemName){
        this.riskItemName = riskItemName;
    }

    public String getRiskItemName() {
        return riskItemName;
    }

    public void setRiskItemName(String riskItemName) {
        this.riskItemName = riskItemName;
    }
}
