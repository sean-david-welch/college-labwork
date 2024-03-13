    public class LeapYear {
    private int inputYear;
    private boolean isLeapYear;

    public int getInputYear(){
        return inputYear;
    }

    public boolean getLeapYear(){
        return isLeapYear;
    }

    public void setInputYear(int inputYear){
        if (inputYear > 0 && inputYear < 1000000) {
            this.inputYear = inputYear;
            setLeapYear();
        } else {
            System.out.println("input must be greater than 0 or less than one million");
        }
    }

    public void setLeapYear(){
        isLeapYear = (inputYear % 4 == 0 && (inputYear % 100 != 0 || inputYear % 400 == 0));
    }
}