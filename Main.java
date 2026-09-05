public class Main {
    public static void main(String[] args){
        BlockChain blockChain = new BlockChain();

        // blockChain.addBlock("First Block");
        // System.out.println("Added First Block");

        // blockChain.addBlock("Second Block");
        // System.out.println("Added Second Block");

        // blockChain.addBlock("Third Block");
        // System.out.println("Added Third Block");

        //  blockChain.addBlock("Fourth Block");
        // System.out.println("Added Fourth Block");

        //  blockChain.addBlock("Fifth Block");
        // System.out.println("Added Fifth Block");

        HoneyBatch batch1 = new HoneyBatch("001", "Krishna", "HIVE-101", "Coimbatore, Tamil Nadu", "WildFlower", 25, "2026-09-05");

        HoneyEvent event1 = new HoneyEvent(batch1.batchId, "HARVESTED", "25 kg harvested from Hive H-101","2026-09-05 10:30");
        HoneyEvent event2 = new HoneyEvent(batch1.batchId, "QUALITY_TESTED", "Quality test passes","2026-09-06 12:00");
        HoneyEvent event3 = new HoneyEvent(batch1.batchId, "PACKAGED", "25 kg packaged into 50 jars","2026-09-07 6:00");

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

        // blockChain.chain.get(1).data="Changed Data";
        System.out.println("Blockchain Valid: "+blockChain.isChainValid());
    }
}

