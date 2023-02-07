import java.util.Scanner;

public class AffineCipher {


    public static String encrypt(String plaintext) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Secret Key in order of Multiplicative key , additive key for eg - (7 2) : " );
        int multikey = sc.nextInt();
        int addkey = sc.nextInt();

        String encryptext = "";

        for(int i = 0 ; i < plaintext.length() ; i++){

            char a = plaintext.charAt(i);
            int b = (int)a - 97;
            int encrypvalue = ((b*multikey)+addkey)%26;
            encrypvalue += 65;
            char value = (char)encrypvalue;
            encryptext += value;

        }
        return encryptext;
        
    }

    //Finds multiplicative inverse of multiplicative Key
public static int modInverse(int a) {

    int inverse = 0;
        for (int i = 1; i < 26 ; i++){
          if (((a%26) * (i%26)) %26 == 1 )
          inverse += i;
        }
        return inverse;
      
  }

    public static String decrypt(String plaintext) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Secret Key in order of Multiplicative key , additive key for eg - (7 2) : " );
        int multikey = sc.nextInt();
        int addkey = sc.nextInt();

        int InverseMultiKey = modInverse(multikey);

        String decryptext = "";

        for(int i = 0 ; i < plaintext.length() ; i++){

            char a = plaintext.charAt(i);
            int b = (int)a - 65;
            int decrypvalue = Math.floorMod((b-addkey)*InverseMultiKey,26);
            decrypvalue += 97;
            char value = (char)decrypvalue;
            decryptext += value;

        }
        return decryptext;
        
    }

    public static void main(String[] args) {

        System.out.println("Hi Welcome , This is a Affine Cipher ");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Text You Want to Encrypt / Decrypt : ");
        String Input = sc.next();

        if(Input.equals(Input.toLowerCase())){

            System.out.println("Your Encrypted Message is : " + encrypt(Input));

        }
        else
        System.out.println("Your Decrypted Message is : " + decrypt(Input));
                    
        }

    }
    
