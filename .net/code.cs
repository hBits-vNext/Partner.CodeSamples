using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string algorithm = "HMACSHA256";
        string key = "your-secret-key";
        string data = "data-to-sign";

        using (HMAC hmac = HMAC.Create(algorithm))
        {
            hmac.Key = Encoding.UTF8.GetBytes(key);
            byte[] hash = hmac.ComputeHash(Encoding.UTF8.GetBytes(data));
            string signature = Convert.ToBase64String(hash);
            Console.WriteLine("Signature: " + signature);
        }

        string nonce = Guid.NewGuid().ToString();
        Console.WriteLine("Nonce: " + nonce);
    }
}
