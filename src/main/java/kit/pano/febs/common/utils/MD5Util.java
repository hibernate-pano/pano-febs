package kit.pano.febs.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Pano
 */
public class MD5Util {

    private static final String ALGORITHM_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

    protected MD5Util() {

    }

    public static String encrypt(String password) {
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(password), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String username, String password) {
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(username.toLowerCase() + password),
                HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("pano", "1234qwer"));
    }

}
