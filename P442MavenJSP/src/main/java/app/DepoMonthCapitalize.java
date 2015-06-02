package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DepoMonthCapitalize extends DepoBase{
	private static final long serialVersionUID = 1L;
	
	public DepoMonthCapitalize(){   }
	
	public DepoMonthCapitalize(Date startDate, int dayLong, double sum, double interestRate){
		super(startDate, dayLong, sum, interestRate);
	}
	
	public double getInterest(){
		double interest = 0.0;          // проценты за текущий период
		double capital = 0.0;           // начисленные проценты
		double tempSum = sum;
		
		Instant instant = Instant.ofEpochMilli(startDate.getTime());
		LocalDate beginPeriod = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		LocalDate start = beginPeriod;
		LocalDate end = start.plusDays(dayLong);
		LocalDate endPeriod = beginPeriod;

		while (true){
            beginPeriod = endPeriod.plusDays(1);
			endPeriod = beginPeriod.plusMonths(1);
			endPeriod = LocalDate.of(endPeriod.getYear(), endPeriod.getMonth(), 1);
            endPeriod = endPeriod.minusDays(1);
			if (endPeriod.isAfter(end)) {
				break;
			}
			interest = calculateInterest(beginPeriod, endPeriod);
			capital += interest;
			sum += interest;
		}
		interest = calculateInterest(beginPeriod, end);
		capital += interest;
		sum = tempSum;
		return capital;
	}
}
