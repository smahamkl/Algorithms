package examples.others;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.*;
import java.nio.*;

public class Sample3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		InputStreamReader rdr = new InputStreamReader(
				new FileInputStream("/Users/smahamka/Desktop/extn_mcc_row_id.d170402.lkup"), Charset.forName("IBM500"));
		String line = null;
		char c;
		do
		{
		   c=(char) rdr.read(); 
		   if(c== '\n')
		      break; 
		   line += c + "";
		}while(c != -1);
		
		System.out.println(line);

	}

}
