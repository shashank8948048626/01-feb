package practise;

import java.util.Date;

public class practice {
	public static void main(String[] args) {
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); 
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth();
		String FinalFormate = YYYY +"-"+MM+"-"+ DD;
		System.out.println(FinalFormate);
		
	}

}
