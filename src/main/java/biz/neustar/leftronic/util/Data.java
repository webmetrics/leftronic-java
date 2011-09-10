package biz.neustar.leftronic.util;

public class Data {
    private String accessKey;
    private String streamName;
    private Object point;

    public Data(String accessKey, String streamName, Object point) {
        this.accessKey = accessKey;
        this.streamName = streamName;
        this.point = point;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getStreamName() {
        return streamName;
    }

    public Object getPoint() {
        return point;
    }
}

