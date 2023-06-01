public class Country {
    private String name;
    private String region;
    private double population;
    private double area;
    private double popDensity;
    private double shoreline;
    private double migration;
    private double infantMortality;
    private double gdp;
    private double literacy;

    public Country(String name, String region, double population, double area, double popDensity, double shoreline, double migration, double infantMortality, double gdp, double literacy) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.area = area;
        this.popDensity = popDensity;
        this.shoreline = shoreline;
        this.migration = migration;
        this.infantMortality = infantMortality;
        this.gdp = gdp;
        this.literacy = literacy;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getPopDensity() {
        return popDensity;
    }

    public double getShoreline() {
        return shoreline;
    }

    public double getMigration() {
        return migration;
    }

    public double getInfantMortality() {
        return infantMortality;
    }

    public double getGdp() {
        return gdp;
    }

    public double getLiteracy() {
        return literacy;
    }

    public void setLiteracy(double literacy) {
        this.literacy = literacy;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public void setInfantMortality(double infantMortality) {
        this.infantMortality = infantMortality;
    }

    public void setMigration(double migration) {
        this.migration = migration;
    }

    public void setShoreline(double shoreline) {
        this.shoreline = shoreline;
    }

    public void setPopDensity(double popDensity) {
        this.popDensity = popDensity;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + " " + region + " " + population + " " + area + " " + popDensity + " " + shoreline + " " + migration + " " + infantMortality + " " + gdp + " " + literacy;
    }
}
