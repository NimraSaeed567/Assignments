package projecttest;

public class libraryevent {
    private String eventType;
    private String mediaType;
    private String mediaTitle;

    public libraryevent(String eventType, String mediaType, String mediaTitle) {
        this.eventType = eventType;
        this.mediaType = mediaType;
        this.mediaTitle = mediaTitle;
    }

  
    public String getEventType() {
        return eventType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }
}


