public class Main {
    public static void main(String[] args){
        BlockChain blockChain = new BlockChain();

        blockChain.addBlock("First Block");
        System.out.println("Added First Block");

        blockChain.addBlock("Second Block");
        System.out.println("Added Second Block");

        blockChain.addBlock("Third Block");
        System.out.println("Added Third Block");

         blockChain.addBlock("Fourth Block");
        System.out.println("Added Fourth Block");

         blockChain.addBlock("Fifth Block");
        System.out.println("Added Fifith Block");

        for(Block block:blockChain.chain){
            System.out.println("Block Number(Index): "+block.blockNumber);
            System.out.println("Data: "+block.data);
            System.out.println("Previous block's hash: "+block.previousHash);
            System.out.println("Current block's hash: "+block.hash);
            System.out.println("---------------------");
        }

    }
}
