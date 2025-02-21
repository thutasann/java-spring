const fetchWithError = (): Promise<string> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => reject('Error fetching data!'), 1000);
  });
};

fetchWithError()
  .then(console.log)
  .catch((err) => {
    throw new Error(err);
  })
  .finally(() => console.log('Operation finished!'));
