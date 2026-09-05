import java.util.ArrayList;

public class BlockChain {
    ArrayList<Block> chain = new ArrayList<>();

    public BlockChain(){

        HoneyEvent genesisEvent = new HoneyEvent("GENESIS", "GENESIS", "Honey Chain started","NILL");

        Block genesis = new Block(0, genesisEvent ,"0");

        chain.add(genesis);
    }


    public void addBlock(HoneyEvent event){

        Block previousBlock = chain.get(chain.size()-1);

        Block newBlock = new Block(chain.size(), event, previousBlock.hash);
        // System.out.println("Starting mining...");
        newBlock.mineBlock(4);
        // System.out.println("Finished mining...");

        chain.add(newBlock);
    }

    public boolean isChainValid(){
        for(int i=1;i<chain.size();i++){

            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i-1);
            //checking if the current block's hash was changed
            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.print("Block Data Changed!");
                return false;
            }
            //checking if the chain is still valid
            if(!currentBlock.previousHash.equals(previousBlock.hash)){
                System.out.println("Chain Broken!");
                return false;
            }

        }
            
        return true;
    }
}
