package com.reaktorlabs.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Viki
 */
public class ClosestDonationService {

    public ClosestDonationService() {
    }
    
    public String getClosestDonation(String location) throws MalformedURLException, ProtocolException, UnsupportedEncodingException, IOException {
        String urlParameters  = "name=" + location + "&yt2=KERESÉS";
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        String request        = "https://www.veradas.hu/adj-vert/veradasok";
        URL    url            = new URL( request );
        
        HttpsURLConnection conn= (HttpsURLConnection) url.openConnection();
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "POST" );
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setUseCaches( false );
        
        Map<String,String> arguments = new HashMap<>();
        arguments.put("city", location);
        arguments.put("yt2", "KERESÉS");
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        
        conn.setFixedLengthStreamingMode(length);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
        conn.setRequestProperty("Cookie", "_ga=GA1.2.1539086013.1527083147; PHPSESSID=ne4b0aakrsitlu5rctf0a4prh0; _gid=GA1.2.971391929.1527332968; _gat=1");
        conn.connect();
        try(OutputStream os = conn.getOutputStream()) {
            os.write(out);
        }
        
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        
        Pattern pat = Pattern.compile("<table[A-z\\s=\"-<>áÁéÉöÖüÜóÓőŐúÚűŰíÍ0-9{}\\!\\?]*<\\/table>");
        Matcher mat = pat.matcher(response);
        
        if (mat.find()) {
            StringBuilder builder = new StringBuilder(mat.group());
            builder = builder.insert(14, "table table-hover ");
            return builder.toString();
        }
        
        return "Sajnáljuk, de ezen a településen a közeljövőben nincs mód véradásra.";
    }
    
}
