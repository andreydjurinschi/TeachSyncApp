package teachsync.demo.utils;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class PasswordHash {


    private static BcryptFunction bcryptFunction = BcryptFunction.getInstance(Bcrypt.B, 12);


    /**
     * Хэширование пароля польщователей
     */
    public String hash(String password) {
        Hash hash = Password.hash(password).with(bcryptFunction);
        return hash.getResult();
    }

    /**
     * Дехэширование и проверка пароля
     */
    public boolean verify(String password, String hash) {
        return Password.check(password, hash).with(bcryptFunction);
    }
}
