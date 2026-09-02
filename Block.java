import java.security.MessageDigest;

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

    public String sha256(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder result = new StringBuilder();

            for(byte b : bytes){
                result.append(String.format("%02x", b));
            }
            return result.toString();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
