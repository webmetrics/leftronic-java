package biz.neustar.leftronic.util;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class LeftronicHttpClient extends DefaultHttpClient {
    private int maxThreads;

    public LeftronicHttpClient(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    @Override
    protected HttpParams createHttpParams() {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setUserAgent(params, "Leftronic Client/" + Version.get());

        return params;
    }

    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        try {
            registry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        } catch (Exception e) {
            throw new RuntimeException("Could not register SSL socket factor for Loggly", e);
        }

        ThreadSafeClientConnManager connManager = new ThreadSafeClientConnManager(registry);
        connManager.setMaxTotal(maxThreads);
        connManager.setDefaultMaxPerRoute(maxThreads);

        return connManager;
    }

}
