package Re_Useable;

import java.io.FileWriter;
import java.io.IOException;

public class csv_file {
	

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\r\n";
	
	public static void ImportMeterNumber(String fileName, String header , long serviceId, String meterNo, String status, String Consumption_Type, String Configuration, String Multiplier,String Constant, String Hazard, String Location, String Additional_Site_Info, String Meter_Point_ID, String Next_Scheduled_Read_Date, String Manufacturer, String Model, String Meter_Read_Type, String Route, String Walk_Order, String Meter_Installation_Type, String Date) {

		String FILE_HEADER = header;
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
		 
	 
			fileWriter.append( String.valueOf(serviceId));
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( meterNo);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( status);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append(Consumption_Type);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Configuration);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Multiplier);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Constant);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Hazard);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Location);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Additional_Site_Info);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Meter_Point_ID);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Next_Scheduled_Read_Date);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Manufacturer);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Model);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Meter_Read_Type);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Route);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Walk_Order);
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append( Meter_Installation_Type);
				fileWriter.append(COMMA_DELIMITER);
				
				
			
				fileWriter.append( Date);
				fileWriter.append(COMMA_DELIMITER);
				
				

			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			

		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
