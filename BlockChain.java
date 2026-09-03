import java.util.ArrayList;

public class BlockChain {
    ArrayList<Block> chain = new ArrayList<>();

    public BlockChain(){

        Block genesis = new Block(0, "Initial Block", "0");


        chain.add(genesis);
    }

    public void addBlock(String data){

        Block previousBlock = chain.get(chain.size()-1);

        Block newBlock = new Block(chain.size(), data, previousBlock.hash);

        newBlock.mineBlock(4);

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
