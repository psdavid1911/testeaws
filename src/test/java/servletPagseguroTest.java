import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author psdav
 */
public class servletPagseguroTest{

    public servletPagseguroTest(){
    }

    @Test
    public void testDoGet() throws Exception{
        CloseableHttpClient httpclient=HttpClients.createDefault();
        try{
            HttpGet httpget=new HttpGet("http://www.google.com/");
            System.out.println("Executing request "+httpget.getRequestLine());
            // Create a custom response handler
            ResponseHandler<String> responseHandler=new ResponseHandler<String>(){
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException,IOException{
                    int status=response.getStatusLine().getStatusCode();
                    if(status>=200&&status<300){
                        HttpEntity entity=response.getEntity();
                        return entity!=null?EntityUtils.toString(entity):null;
                    }else
                        throw new ClientProtocolException("Unexpected response status: "+status);
                }
            };
            String responseBody=httpclient.execute(httpget,responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }finally{
            httpclient.close();
        }
    }
}
