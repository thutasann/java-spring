const delay = (ms: number): Promise<void> => {
  return new Promise((resolve) => setTimeout(resolve, ms));
};

delay(1000)
  .then(() => console.log('Executed after 1 second'))
  .catch((error) => console.error('Error => ', error));
