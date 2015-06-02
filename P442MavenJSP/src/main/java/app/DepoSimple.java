package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DepoSimple extends DepoBase{
	private static final long serialVersionUID = 1L;
	
	public DepoSimple(){   }
	
	public DepoSimple(Date startDate, int dayLong, double sum, double interestRate){
		super(startDate, dayLong, sum, interestRate);
	}
	
	public double getInterest(){
		double interest = 0.0;
		Instant instant = Instant.ofEpochMilli(startDate.getTime());
		LocalDate start = LocalDateTime.ofInstant(instant, 	ZoneId.systemDefault()).toLocalDate();
		LocalDate maturity = start.plusDays(dayLong);
		int startYear = start.getYear();
		int maturityYear = maturity.getYear();
		start = start.plusDays(1);
		if (startYear == maturityYear){
			interest = calculateInterest(start, maturity);
		} else {
			LocalDate endOfYear = LocalDate.of(startYear, 12, 31);
			interest = calculateInterest(start, endOfYear);
			LocalDate beginOfYear = endOfYear.plusDays(1);
			interest += calculateInterest(beginOfYear, maturity);
		}
		return interest;
	}

}
