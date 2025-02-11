import { fetchData } from './chaining';

const asyncFunction = async () => {
  try {
    const data1 = await fetchData('valid');
    console.log('data1 ==> ', data1);
  } catch (error) {
    console.error('Error: ', error);
  }
};
asyncFunction();
