public class HoneyBatch {
    String batchId;
    String beekeeperName;
    String hiveId;
    String location;
    String honeyType;
    double quantity;
    String harvestDate;

    public HoneyBatch(String batchId, String beekeeperName, String hiveId, String location, String honeyType, double quantity, String harvestDate){
        this.batchId = batchId;
        this.beekeeperName = beekeeperName;
        this.hiveId = hiveId;
        this.location = location;
        this.honeyType = honeyType;
        this.quantity = quantity;
        this.harvestDate = harvestDate;
    }

    @Override
    public String toString(){
        return "Batch ID: "+batchId+", Beekeeper: "+beekeeperName+", Hive: "+hiveId+", Location: "+location+", Honey Type: "+honeyType+", Quantity: "+quantity+" kg"+", Harvest Date: "+harvestDate;
    }

}
