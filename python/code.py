import hashlib
import hmac
import base64

def generate_signature(algorithm, key, data):
    hashed = hmac.new(key.encode('utf-8'), data.encode('utf-8'), hashlib.__dict__[algorithm])
    signature = base64.b64encode(hashed.digest()).decode('utf-8')
    return signature

algorithm = 'sha256'
key = 'your-secret-key'
data = 'data-to-sign'
signature = generate_signature(algorithm, key, data)
print("Signature:", signature)

import secrets
nonce = secrets.token_hex(16)
print("Nonce:", nonce)
