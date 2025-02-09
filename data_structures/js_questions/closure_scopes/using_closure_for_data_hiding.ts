function createSecret(secret: string) {
  return {
    getSecret: () => secret,
  };
}
const obj = createSecret('Hidden meessage');
console.log(obj.getSecret());
