package app;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class DepoBase implements Comparable<DepoBase>, Serializable{
	private static final long serialVersionUID = 1L;
	protected Date startDate;
	protected int dayLong;
	protected double sum;
	protected double interestRate;
	
	public DepoBase() {	}
	
	public DepoBase(Date startDate, int dayLong, double sum, double interestRate){
		this.startDate = startDate;
		this.dayLong = dayLong;
		this.sum = sum;
		this.interestRate = interestRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDayLong() {
		return dayLong;
	}

	public void setDayLong(int dayLong) {
		this.dayLong = dayLong;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest(LocalDate start, LocalDate maturity){
		int daysInYear = 365;
		if (start.isLeapYear()){
			daysInYear = 366;
		}
		double dayCf = start.until(maturity, ChronoUnit.DAYS) + 1;
        double interest = sum * (interestRate / 100.0) * (dayCf / daysInYear);	
        return interest;
	}
	
	public abstract double getInterest();
	
	public int compareTo(DepoBase depo) {
        if ((this.getInterest() - depo.getInterest()) > 0) return 1;
        if ((this.getInterest() - depo.getInterest()) < 0) return -1;
        return 0;
	}

	public String getDataForWeb(){
		SimpleDateFormat dtFrm = new 	SimpleDateFormat("dd.MM.yyyy"); 
		String ret = "<tr><td>";
		ret += dtFrm.format(startDate) +"<td>";
		ret += dayLong + "<td>" + sum + "<td>" + 	interestRate + "</tr>";
		return ret;
	}
}
