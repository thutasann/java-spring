type Transaction = {
  amount: number;
  type: 'income' | 'expense';
};

const transactions: Transaction[] = [
  { amount: 100, type: 'income' },
  { amount: 50, type: 'expense' },
  { amount: 200, type: 'income' },
  { amount: 80, type: 'expense' },
];

const summary = transactions.reduce(
  (acc, transaction) => {
    if (transaction.type === 'income') {
      acc.totalIncome += transaction.amount;
    } else {
      acc.totalIncome -= transaction.amount;
    }
    return acc;
  },
  { totalIncome: 0, totalExpenses: 0 }
);

console.log('summary ==> ', summary);
