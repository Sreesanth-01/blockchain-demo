public class HoneyEvent {
    String batchId;
    String eventType;
    String details;

    public HoneyEvent(String batchId, String eventType, String details){
        this.batchId = batchId;
        this.eventType = eventType;
        this.details = details;
    }

    @Override
    public String toString(){
        return "Batch ID: "+ batchId + ", Event: "+eventType+", Details: "+details;
    }
}
