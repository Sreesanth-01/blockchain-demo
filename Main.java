import java.security.KeyPair;
import java.security.PrivateKey;

public class Main {
    public static void main(String[] args){
        BlockChain blockChain = new BlockChain();

        KeyPair keys = KeyManager.generateKeyPair();

        PrivateKey privateKey = keys.getPrivate();


        HoneyBatch batch1 = new HoneyBatch("001", "Krishna", "HIVE-101", "Coimbatore, Tamil Nadu", "WildFlower", 25, "2026-09-05");

        HoneyEvent event1 = new HoneyEvent(batch1.batchId, "HARVESTED","Beekeeper", "25 kg harvested from Hive H-101","2026-09-05 10:30");
        event1.signEvent(privateKey,keys.getPublic());

        boolean signatureValid = event1.verifySignature();

        // System.out.println("Signature Valid: "+signatureValid);

        //for prototype we will use same key pair
        HoneyEvent event2 = new HoneyEvent(batch1.batchId, "QUALITY_TESTED","ABC Labs", "Quality test passes","2026-09-06 12:00");
        event2.signEvent(privateKey,keys.getPublic());
        HoneyEvent event3 = new HoneyEvent(batch1.batchId, "PACKAGED", "Processor","25 kg packaged into 50 jars","2026-09-07 6:00");
        event3.signEvent(privateKey,keys.getPublic());

        blockChain.addBlock(event1);
        blockChain.addBlock(event2);
        blockChain.addBlock(event3);

        System.out.println("##################");

        for(Block block:blockChain.chain){
            System.out.println("Block Number(Index): "+block.blockNumber);
            System.out.println("Data: "+block.data);
            System.out.println("Previous block's hash: "+block.previousHash);
            System.out.println("Current block's hash: "+block.hash);
            System.out.println("---------------------");
        }
        System.out.println("Blockchain Valid: "+blockChain.isChainValid());
    }
}

