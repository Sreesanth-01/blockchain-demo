import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class HoneyEvent {
    String batchId;
    String eventType;
    String actor;
    String details;
    String timestamp;

    String signerId;
    PublicKey signerPublicKey;
    String digitalSignature;

    public HoneyEvent(String batchId, String eventType, String actor, String details, String timestamp){
        this.batchId = batchId;
        this.eventType = eventType;
        this.actor = actor;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getData(){
        return batchId+eventType+actor+details+timestamp;
    }

    public void signEvent(Participant participant){
        try {
            this.signerId = participant.participantId;
            this.signerPublicKey = participant.publicKey;

            Signature signature = Signature.getInstance("SHA256withECDSA");

            signature.initSign(participant.privateKey);

            signature.update(getData().getBytes(StandardCharsets.UTF_8));

            byte[] signatureBytes = signature.sign();

            digitalSignature = Base64.getEncoder().encodeToString(signatureBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifySignature(){
        try {
            if(digitalSignature == null || signerPublicKey == null){
                return false;
            }

            Signature signature = Signature.getInstance("SHA256withECDSA");

            signature.initVerify(signerPublicKey);

            signature.update(getData().getBytes(StandardCharsets.UTF_8));

            byte[] signatureBytes = Base64.getDecoder().decode(digitalSignature);

            return signature.verify(signatureBytes);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Batch ID: "+ batchId + ", Event: "+eventType+", Actor: "+actor+", Details: "+details+", Time: "+timestamp+", Signer ID: "+signerId+", Signature: "+digitalSignature;
    }
}
