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

        chain.add(newBlock);
    }
}
