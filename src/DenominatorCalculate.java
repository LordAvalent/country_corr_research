import java.util.List;

public class DenominatorCalculate {

    public double calculateDenominator(List<Double> xList, List<Double> yList) {
        int size = xList.size();
        double xAverage = 0.0;
        double yAverage = 0.0;
        double xException = 0.0;
        double yException = 0.0;
        double temp1 = 0.0;
        double temp2 = 0.0;

        for(int i = 0; i < size; i++){
            temp1 += xList.get(i);
        }
        xAverage = temp1/size;

        for(int i = 0; i < size; i++){
            temp2 += yList.get(i);
        }
        yAverage = temp2/size;

        for(int i = 0; i < size; i++){
            xException += Math.pow(xList.get(i) - xAverage, 2);
            yException += Math.pow(yList.get(i) - yAverage, 2);
        }

        return Math.sqrt(xException * yException);
    }
}
