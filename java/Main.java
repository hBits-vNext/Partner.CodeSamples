import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String algorithm = "HmacSHA256";
        String key = "your-secret-key";
        String data = "data-to-sign";

        try {
            Mac hmac = Mac.getInstance(algorithm);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
            hmac.init(secretKeySpec);
            byte[] digest = hmac.doFinal(data.getBytes());
            String signature = Base64.getEncoder().encodeToString(digest);
            System.out.println("Signature: " + signature);

            String nonce = UUID.randomUUID().toString();
            System.out.println("Nonce: " + nonce);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
