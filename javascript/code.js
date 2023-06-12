const crypto = require('crypto');

function generateNonce() {
  const nonceBytes = crypto.randomBytes(8);
  return nonceBytes.toString('hex');
}

function generateSignature(secret, domain, nonce) {
  const data = domain + nonce;
  const algorithm = 'sha256';
  const encoding = 'base64';

  const hmac = crypto.createHmac(algorithm, secret);
  hmac.update(data);
  const signature = hmac.digest(encoding);

  return signature;
}

const secret = '123';
const domain = 'https://www.hbits.com';
const nonce = generateNonce();
const signature = generateSignature(secret, domain, nonce);

console.log('Signature:', signature);
