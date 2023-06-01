import java.util.List;

public class NumeratorCalculate {

    protected List<Double> xList, yList;

    public NumeratorCalculate(List<Double> xList, List<Double> yList){
        this.xList = xList;
        this.yList = yList;
    }

    public double calculateNumerator(){
        double result = 0.0;
        double xAverage = 0.0;
        double temp = 0.0;

        int xSize = xList.size();
        for(int x = 0; x < xSize; x++){
            temp += xList.get(x);
        }
        xAverage = temp/xSize;

        double yAverage = 0.0;
        temp = 0.0;
        int ySize = yList.size();
        for(int x = 0; x < ySize; x++){
            temp += yList.get(x);
        }
        yAverage = temp/ySize;

        for(int x = 0; x < xSize; x++){
            result += (xList.get(x) - xAverage) * (yList.get(x) - yAverage);
        }
        return result;
    }
}
