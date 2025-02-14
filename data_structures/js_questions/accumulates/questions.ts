type User = {
  id: number;
  name: string;
};

type Item = {
  category: string;
  name: string;
};

const items: Item[] = [
  { category: 'fruit', name: 'apple' },
  { category: 'vegetable', name: 'carrot' },
  { category: 'fruit', name: 'banana' },
  { category: 'vegetable', name: 'broccoli' },
];

class ReduceQuestions {
  main() {
    console.log('\nsumNumbers ==> ', this.sumNumbers([10, 20, 30, 40, 50]));

    console.log(
      '\nflattenArray ==> ',
      this.flattenArray([
        [1, 2],
        [3, 4],
        [5, 6],
      ])
    );

    console.log(
      '\ncountOccurrence ==> ',
      this.countOccurrence(['apple', 'banana', 'apple', 'orange', 'banana', 'apple'])
    );

    console.log(
      '\narray to object ==> ',
      this.arrayToObject([
        { id: 1, name: 'Alice' },
        { id: 2, name: 'Bob' },
        { id: 3, name: 'Charlie' },
      ])
    );

    console.log('\nCalculate Average ==> ', this.calculateAverage([85, 90, 78, 92, 88]));

    console.log('\ngroup by key ==> ', this.groupBy(items, 'category'));

    console.log('\nfibonacc ==> ', this.fibonacci(10));
  }

  sumNumbers(nums: number[]) {
    return nums.reduce((acc, curr) => acc + curr, 0);
  }

  flattenArray<T>(arrays: T[][]): T[] {
    return arrays.reduce((acc, arr) => acc.concat(arr), []);
  }

  countOccurrence<T extends string | number | symbol>(arr: T[]): Record<T, number> {
    return arr.reduce((acc, curr) => {
      acc[curr] = (acc[curr] || 0) + 1;
      return acc;
    }, {} as Record<T, number>);
  }

  arrayToObject<T>(users: User[]): Record<number, User> {
    return users.reduce((acc, user) => {
      acc[user.id] = user;
      return acc;
    }, {} as Record<number, User>);
  }

  calculateAverage(nums: number[]): number {
    const total = nums.reduce((acc, curr) => acc + curr, 0);
    return nums.length ? total / nums.length : 0;
  }

  groupBy<T>(arr: T[], key: keyof T): Record<string, T[]> {
    return arr.reduce((acc, curr) => {
      const keyValue = curr[key] as unknown as string;
      if (!acc[keyValue]) {
        acc[keyValue] = [];
      }
      acc[keyValue].push(curr);
      return acc;
    }, {} as Record<string, T[]>);
  }

  fibonacci(n: number): number[] {
    return Array.from({ length: n }).reduce<number[]>((acc, _, index) => {
      if (index < 2) {
        acc.push(index);
      } else {
        acc.push(acc[index - 1] + acc[index - 2]);
      }
      return acc;
    }, [] as number[]);
  }
}

const reduce_questions = new ReduceQuestions();
reduce_questions.main();
