# Sample Liberty TAI project

This is a projtect to test the error handling behavior in WebSphere Liberty TAI. The behavior is a bit strange when there are error-page defined in the web application:

- If there are no error-page defined for the status code returned by TAI, the error from TAI can be successfully returned to client.
- If there are error-page defined in the web application for the status code returned by TAI, Liberty will always try to use the error-page to display the error, which is un-expected. For servlet, the error-page mappings are only used when Servlet/JSP explicitly call the sendError method.

*Note:* This project can also be used as a sample to create a new TAI.

> Refer to this article about how to create a custom TAI for liberty - [Developing a custom TAI for Liberty](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_8.5.5/com.ibm.websphere.wlp.doc/ae/twlp_dev_custom_tai.html)

