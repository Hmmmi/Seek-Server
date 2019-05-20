package com.ihbut0.server.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.X509Certificate;

public class SSLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ATTR_CER = "javax.servlet.request.X509Certificate";
    private static final String CONTENT_TYPE = "text/plain;charset=UTF-8";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String SCHEME_HTTPS = "https";

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding(DEFAULT_ENCODING);
        PrintWriter out = response.getWriter();
        
        X509Certificate[] certs = (X509Certificate[]) request.getAttribute(ATTR_CER);
        if (certs != null) {
            int count = certs.length;
            for (int i = 0; i < count; i++) {
                out.print( verifyCertificate(certs[i])?"VERIFY_SUCCESS":"VERIFY_FAILED" );//校验结果
            }
        } else {
            if (SCHEME_HTTPS.equalsIgnoreCase(request.getScheme())) {
                out.println("这是一个HTTPS请求，但是没有可用的客户端证书");
            } else {
                out.println("这不是一个HTTPS请求，因此无法获得客户端证书列表 ");
            }
        }
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	doGet(request, response);
    }


    private boolean verifyCertificate(X509Certificate certificate) {
        boolean valid = false;
        try {
            certificate.checkValidity();
            valid=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valid;
    }
}