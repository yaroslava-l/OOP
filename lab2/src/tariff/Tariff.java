package tariff;

public class Tariff implements Comparable  {

    private String name, id;
    private int payroll;
    private double smsprice;

    public Callprices callprices = new Callprices();
    public Parameters parametrers = new Parameters();

    public Tariff() {
        id = "";
    }

    public Tariff(String name, int payroll, double smsprice) {
        this.name = name;
        this.payroll = payroll;
        this.smsprice = smsprice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public void setSmsprice(double smsprice) {
        this.smsprice = smsprice;
    }

    public void setCallprices(Callprices cp) {
        this.callprices = cp;
    }

    public void setParameters(Parameters par) {
        this.parametrers = par;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getPayroll() {
        return payroll;
    }

    public double getSmsprice() {
        return smsprice;
    }

    public Callprices getCallprices() {
        return callprices;
    }

    public Parameters getParameters() {
        return parametrers;
    }


    public class Callprices {
        double insidenetwork, outsidenetwork, tofixedphones;
        public void setInsidenetwork(double insidenetwork) {
            this.insidenetwork = insidenetwork;
        }
        public void setOutsidenetwork(int outsidenetwork) {
            this.outsidenetwork = outsidenetwork;
        }
        public void setTofixedphones(int tofixedphones) {
            this.tofixedphones = tofixedphones;
        }

        public double getInsidenetwork() {
            return insidenetwork;
        }

        public double getOutsidenetwork() {
            return outsidenetwork;
        }

        public double getTofixedphones() {
            return tofixedphones;
        }
    }

    public class Parameters {
        String tariffing;
        int favouritenumbers;
        int connectpayment;
        public void setTariffing(String tariffing) {
            this.tariffing = tariffing;
        }
        public void setFavouritenumbers(int favouritenumbers) {
            this.favouritenumbers = favouritenumbers;
        }
        public void setConnectpayment(int connectpayment) {
            this.connectpayment = connectpayment;
        }

        public String getTariffing() {
            return tariffing;
        }

        public int getFavouritenumbers() {
            return favouritenumbers;
        }

        public int getConnectpayment() {
            return connectpayment;
        }
    }

    @Override
    public String toString() {
        return  "name: " + name + " "
                + "\n\tPayroll: " + payroll + " "
                + "\n\t callprices: " + callprices.insidenetwork + " " + callprices.outsidenetwork + " " + callprices.tofixedphones + " "
                + "\n\t smsprice: " + smsprice + " "
                + "\n\t parameters: " + parametrers.favouritenumbers + " " + parametrers.tariffing + " " + parametrers.connectpayment + " ";
    }
    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Tariff) o).getName());
    }
}

