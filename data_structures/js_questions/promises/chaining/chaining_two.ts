const stepOne = (): Promise<string> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve('Step 1 completed'), 1000);
  });
};

const stepTwo = (prev: string): Promise<string> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(`${prev} -> Step 2 completed`), 1000);
  });
};

const stepThree = (prev: string): Promise<string> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(`${prev} -> Step 3 completed`), 1000);
  });
};

stepOne().then(stepTwo).then(stepThree).then(console.log);
