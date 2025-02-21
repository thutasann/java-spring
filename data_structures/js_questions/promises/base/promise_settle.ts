type Result =
  | {
      status: 'fulfilled';
      value: string;
    }
  | {
      status: 'rejected';
      reason: any;
    };

const promise1 = Promise.resolve('Success 1');
const promise2 = Promise.reject('Error 2');
const promise3 = Promise.resolve('Success 2');

/**
 * `Promise.allSettled` is useful when you want to wait for all promises to settle, regardless of whether they fulfill or reject.
 */
Promise.allSettled([promise1, promise2, promise3]).then((results: Result[]) => {
  results.forEach((result, index) => {
    if (result.status === 'fulfilled') {
      console.log(`Promise ${index + 1} fulfilled with value: ${result.value}`);
    } else {
      console.log(`Promise ${index + 1} rejected with reason: ${result.reason}`);
    }
  });
});
