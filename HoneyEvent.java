public class HoneyEvent {
    String batchId;
    String eventType;
    String actor;
    String details;
    String timestamp;

    public HoneyEvent(String batchId, String eventType, String actor, String details, String timestamp){
        this.batchId = batchId;
        this.eventType = eventType;
        this.actor = actor;
        this.details = details;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "Batch ID: "+ batchId + ", Event: "+eventType+", Actor: "+actor+", Details: "+details+", Time: "+timestamp;
    }
}
