import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("data_countries_world.txt"));
            List<Country> countries = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                String region = scanner.nextLine();
                double population = Integer.parseInt(scanner.nextLine());
                double area = Integer.parseInt(scanner.nextLine());
                double popDensity = Double.parseDouble(scanner.nextLine().replace(",", "."));
                double shoreline = Double.parseDouble(scanner.nextLine().replace(",", "."));
                double migration = Double.parseDouble(scanner.nextLine().replace(",", "."));
                double infantMortality = Double.parseDouble(scanner.nextLine().replace(",", "."));
                double gdp = Integer.parseInt(scanner.nextLine());
                double literacy = Double.parseDouble(scanner.nextLine().replace(",", "."));

                countries.add(new Country(name, region, population, area, popDensity, shoreline, migration, infantMortality, gdp, literacy));
            }
            scanner.close();

            PrintWriter writer = new PrintWriter(new File("corr.txt"));

            writer.write("Correlation research:");
            System.out.println("Correlation research:");
            List<List<Map<String, List<Double>>>> combinations = combinations(countries);
            HashMap<String, Double> map = new HashMap<>();
            combinations.forEach(combination -> {
                List<Double> xList = combination.get(0).entrySet().iterator().next().getValue();
                List<Double> yList = combination.get(1).entrySet().iterator().next().getValue();
                Double CORR = getCoefficient(xList, yList);
                map.put(System.getProperty("line.separator") + "Correlation coefficient for " + combination.get(0).entrySet().iterator().next().getKey() + " and " + combination.get(1).entrySet().iterator().next().getKey() + ": ", CORR);
            });

            HashMap<String, Double> newMap = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for(Map.Entry<String, Double> entry : newMap.entrySet()) {
                String str = entry.getKey() + entry.getValue();
                writer.append(str);
                System.out.println(str);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static private Double getCoefficient(List<Double> xList, List<Double> yList) {
        NumeratorCalculate nc = new NumeratorCalculate(xList, yList);
        double numerator = nc.calculateNumerator();
        DenominatorCalculate dc = new DenominatorCalculate();
        double denominator = dc.calculateDenominator(xList, yList);
        return numerator / denominator;
    }

    static private List<List<Map<String, List<Double>>>> combinations(List<Country> countries) {
        List<Double> population = countries.stream().map(Country::getPopulation).collect(toList());
        List<Double> area = countries.stream().map(Country::getArea).collect(toList());
        List<Double> migration = countries.stream().map(Country::getMigration).collect(toList());
        List<Double> infantMortality = countries.stream().map(Country::getInfantMortality).collect(toList());
        List<Double> gdp = countries.stream().map(Country::getGdp).collect(toList());
        List<Double> literacy = countries.stream().map(Country::getMigration).collect(toList());

        List<Map<String, List<Double>>> dataset = Map.of("population", population, "area", area, "migration", migration, "infantMortality", infantMortality, "gdp", gdp, "literacy", literacy).entrySet().stream().map(e -> {
            Map<String, List<Double>> map = new HashMap<>();
            map.put(e.getKey(), e.getValue());
            return map;
        }).collect(toList());

        List<List<Map<String, List<Double>>>> combinations = new ArrayList<>();

        for (int i = 0; i < dataset.size(); i++)
            for (int j = 0; j < dataset.size(); j++)
                if (i != j) {
                    List<Map<String, List<Double>>> combination = new ArrayList<>(List.of(dataset.get(i), dataset.get(j)));
                    List<Map<String, List<Double>>> combination2 = new ArrayList<>(List.of(dataset.get(j), dataset.get(i)));
                    if (!combinations.contains(combination) && !combinations.contains(combination2))
                        combinations.add(combination);
                }

        return combinations;
    }
}