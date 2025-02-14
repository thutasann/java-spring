type GroupTransaction = {
  amount: number;
  type: 'income' | 'expense' | 'investment';
};

const group_transactions: GroupTransaction[] = [
  { amount: 100, type: 'income' },
  { amount: 50, type: 'expense' },
  { amount: 200, type: 'income' },
  { amount: 80, type: 'expense' },
  { amount: 300, type: 'investment' },
];

const grouped_summary = group_transactions.reduce<Record<string, number>>((acc, transaction) => {
  if (!acc[transaction.type]) {
    acc[transaction.type] = 0;
  }
  acc[transaction.type] += transaction.amount;
  return acc;
}, {});

console.log('grouped_summary', grouped_summary);
