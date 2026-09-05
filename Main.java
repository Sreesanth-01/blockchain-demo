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

        HoneyEvent event1 = new HoneyEvent("001", "HARVESTED", "25 kg harvested from Hive H-101");
        HoneyEvent event2 = new HoneyEvent("001", "QUALITY_TESTED", "Quality test passes");
        HoneyEvent event3 = new HoneyEvent("001", "PACKAGED", "25 kg packaged into 50 jars");

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
