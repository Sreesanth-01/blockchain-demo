public class Block {
    int blockNumber;
    String data;
    String hash;
    String previousHash;

    public Block(int blockNumber, String data, String previousHash){
        this.blockNumber = blockNumber;
        this.data = data;
        this.previousHash = previousHash;

        this.hash = calculateHash();
    }

    public String calculateHash(){
        String info = blockNumber+data+previousHash;

        return sha256(info);
    }
}
