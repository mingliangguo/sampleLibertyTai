package sample;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.websphere.security.WebTrustAssociationException;
import com.ibm.websphere.security.WebTrustAssociationFailedException;
import com.ibm.wsspi.security.tai.TAIResult;
import com.ibm.wsspi.security.tai.TrustAssociationInterceptor;

public class SampleTAI implements TrustAssociationInterceptor {
   public SampleTAI() {
      super();
   }

/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#isTargetInterceptor
 * (javax.servlet.http.HttpServletRequest)
 */
   public boolean isTargetInterceptor(HttpServletRequest req)
                  throws WebTrustAssociationException {
      //Add logic to determine whether to intercept this request
      return true;
   }

/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#negotiateValidateandEstablishTrust
 * (javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
 */
   public TAIResult negotiateValidateandEstablishTrust(HttpServletRequest req,
                    HttpServletResponse resp) throws WebTrustAssociationFailedException {
        // Add logic to authenticate a request and return a TAI result.
        String tai_user = "taiUser";
        resp.setContentType("application/json");
        StringBuilder sb = new StringBuilder();
//        int code = HttpServletResponse.SC_FORBIDDEN;
        int code = 259;
        sb.append("{\"code\":\"").append(code).append("\", \"message\": \"Message from GusTAI\"}");
        try {
			resp.getOutputStream().write(sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return TAIResult.create(code, tai_user);
    }
  
/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#initialize(java.util.Properties)
 */
    public int initialize(Properties arg0)
                    throws WebTrustAssociationFailedException {
        return 0;
    }

/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#getVersion()
 */
    public String getVersion() {
        return "1.0";
    }

/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#getType()
 */
    public String getType() {
        return this.getClass().getName();
    }

/*
 * @see com.ibm.wsspi.security.tai.TrustAssociationInterceptor#cleanup()
 */
    public void cleanup()

    {}
}