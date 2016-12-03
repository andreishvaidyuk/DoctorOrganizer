package sk.upjs.doctororganizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class PasswordHash {
    
    public static String hash(String password) throws NoSuchAlgorithmException{
        String toHash = password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(toHash.getBytes());
        byte[] data = md.digest();
        String hashString = DatatypeConverter.printHexBinary(data);
        return hashString;
    }
    
    public static boolean isExpectedPassword(String password, String hash) throws NoSuchAlgorithmException {
        return hash.equals(PasswordHash.hash(password));
    }
}
