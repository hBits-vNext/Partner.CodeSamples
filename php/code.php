function generateSignature($algorithm, $key, $data) {
    $signature = hash_hmac($algorithm, $data, $key, true);
    return base64_encode($signature);
}

$algorithm = 'sha256';
$key = 'your-secret-key';
$data = 'data-to-sign';
$signature = generateSignature($algorithm, $key, $data);
echo "Signature: " . $signature . "\n";

$nonce = bin2hex(random_bytes(8));
echo "Nonce: " . $nonce . "\n";
