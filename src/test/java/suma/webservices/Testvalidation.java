package suma.webservices;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
*/

public class Testvalidation {
	
		
	   @Given("download WebService Response In LocalFile") 
	   public void download_WebService_Response_In_LocalFile()
       {
             OutputStream out = null;
             URLConnection conn = null;
             InputStream in = null;
             try
             {
                    // Creation de l'URL
                    URL url = new URL("http://139.54.130.34:30800");
                    // Ouverture du stream sur le fichier XML local
                    out = new BufferedOutputStream(new FileOutputStream("/tmp/response.txt"));
                    conn = url.openConnection();
                    in = conn.getInputStream();
                    // Get the data
                    byte[] buffer = new byte[1024];
                    int numRead;
                    while ((numRead = in.read(buffer)) != -1)
                           out.write(buffer, 0, numRead);
             }
             catch (Exception exception)
             {
                    exception.printStackTrace();
             }
             finally
             {
                    try
                    {
                           if (in != null)in.close();
                           if (out != null)out.close();
                    }
                    catch (IOException ioe)
                    {
                           System.err.println(ioe); 
                           ioe.printStackTrace();
                    }
             }
       }

		
	   @When("get String From WebService") 
       public void get_String_From_WebService()throws IOException { 
       {
		   BufferedReader br = new BufferedReader(new FileReader("/tmp/response.txt"));     
		   if (br.readLine() != null) {
		       System.out.println("output is redirected, and file is not empty");
		   }
		   else
		   {
			   System.out.println("dashboard is not up, and file is empty"); 
		   }
       }
	   }


		
	   @Then("validate result") 
	   public void validate_result() throws IOException { 
		   BufferedReader in = new BufferedReader(new FileReader("/tmp/response.txt"));
		   String line = in.readLine();
		   while(line != null)
		   {
		     System.out.println(line);
		     line = in.readLine();
		   }
		   in.close();
	   }    
	}
