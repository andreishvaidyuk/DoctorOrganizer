package sk.upjs.doctororganizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class PasswordHash {
    
    public static String hash(String password, String salt) throws NoSuchAlgorithmException{
        String toHash = password + salt;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(toHash.getBytes());
        byte[] data = md.digest();
        String hashString = DatatypeConverter.printHexBinary(data);
        return hashString;
    }
    
    public static boolean isExpectedPassword(String password, String salt, String hash) throws NoSuchAlgorithmException {
        return hash.equals(PasswordHash.hash(password,salt));
    }
}
