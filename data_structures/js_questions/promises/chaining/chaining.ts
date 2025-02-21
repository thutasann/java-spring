export const fetchData = (url: 'valid' | 'invalid'): Promise<string> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (url === 'valid') {
        resolve('Data fetched');
      } else {
        reject('Invalid URL');
      }
    }, 1000);
  });
};

fetchData('valid')
  .then((data) => {
    console.log(data);
    return fetchData('invalid');
  })
  .then((moreData) => {
    console.log(moreData);
  })
  .catch((error) => {
    console.error('Error: ', error);
  });
