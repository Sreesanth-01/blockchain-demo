import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

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

    public static void main(String[] args){
        KeyPair keys = generateKeyPair();

        PrivateKey privateKey = keys.getPrivate();
        PublicKey publicKey = keys.getPublic();

        String event = "001 | HARVESTED | 25kg";

        //signing:
        byte[] digitalSignature = sign(event,privateKey);
        //Converting to readable text:
        String signatureText = Base64.getEncoder().encodeToString(digitalSignature);

        System.out.println("Honey event: " + event);

        System.out.println();

        System.out.println("Digital Signature: "+signatureText);

        System.out.println();

        boolean valid = verifySign(event, digitalSignature, publicKey);

        System.out.println("Signature valid: "+valid);

        //Changing the event:
        String changedEvent = "001 | HARVESTED | 50 kg";

        boolean changedValid = verifySign(changedEvent, digitalSignature, publicKey);

         System.out.println("Signature valid after change: "+ changedValid);
    }

}
