package HW4.strategy;

import HW4.model.Contract;

public class CompleteRecognitionStrategy implements RecognitionStrategy {

    @Override
    public void calculateRevenueRecognitions(Contract contract) {
        contract.addRevenueRecognition(
                contract.getRevenue(), contract.getDateSigned());
    }

}
