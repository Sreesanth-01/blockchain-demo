import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignature {
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

    public static byte[] sign(String data,PrivateKey privateKey){
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");

            signature.initSign(privateKey);

            signature.update(data.getBytes(StandardCharsets.UTF_8));

            return signature.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean verifySign(String data,byte[] signatureBytes, PublicKey publicKey){
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");

            signature.initVerify(publicKey);

            signature.update(data.getBytes(StandardCharsets.UTF_8));

            return signature.verify(signatureBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
