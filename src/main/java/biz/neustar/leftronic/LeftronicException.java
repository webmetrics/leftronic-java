package biz.neustar.leftronic;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class LeftronicException extends Exception {
    private int statusCode;
    private String reason;
    private String body;

    public LeftronicException(HttpResponse response) {
        super(response.getStatusLine().toString());

        statusCode = response.getStatusLine().getStatusCode();
        reason = response.getStatusLine().getReasonPhrase();

        try {
            body = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            // ignore!
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    public String getBody() {
        return body;
    }
}
