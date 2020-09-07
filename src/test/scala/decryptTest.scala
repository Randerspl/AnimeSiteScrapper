import java.nio.charset.StandardCharsets
import java.util

import javax.crypto.{Cipher, SecretKeyFactory}
import javax.crypto.spec.{IvParameterSpec, PBEKeySpec, SecretKeySpec}
import org.apache.commons.codec.binary.Hex
import org.apache.commons.net.util.Base64
import org.scalatest.FunSuite
import sun.nio.cs.UTF_8

class decryptTest extends FunSuite {

    case class DataHash( a: String, b: String, v: String )

    private val key = "s05z9Gpd=syG^7{"


    test( "decryptTest" ) {
        assert( decrypt( DataHash( a = "yhN+ty9DPhnSFkoarIwmvT0WjF1LVx9cczqCZV7Yhlyrw2WcI/FSi6VeWra34y+v", b = "7db71806875a556eacc782cf221ccc9d", v = "7f8e57002f8d53e2" ) ) == """"https:\/\/aparat.cam\/embed-k3jsob7tgzrh.html"""" )
    }


    private def decrypt( dataHash: DataHash ): String = {
        AESHelperJava.decrypt( key, Hex.decodeHex( dataHash.v ), dataHash.a )
    }

}
