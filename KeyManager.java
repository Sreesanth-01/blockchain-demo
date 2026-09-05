import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyManager {
    public static KeyPair generateKeyPair(){
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
            generator.initialize(256);

            return generator.generateKeyPair();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        KeyPair keyPair = generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("Private key: ");
        System.out.println(privateKey);
        System.out.println();
        System.out.println("Public key: ");
        System.out.println(publicKey);
    }
}
