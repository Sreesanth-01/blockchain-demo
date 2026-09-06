import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Participant {
    String participantId;
    String name;
    String role;

    PrivateKey privateKey;
    PublicKey publicKey;

    public Participant(String participantId, String name, String role){
        this.participantId = participantId;
        this.name = name;
        this.role = role;

        KeyPair keyPair = KeyManager.generateKeyPair();

        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }
}
