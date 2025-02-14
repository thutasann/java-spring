interface Order {
  id: number;
  items: { productId: number; quantity: number; price: number }[];
}

const orders: Order[] = [
  {
    id: 1,
    items: [
      { productId: 1, quantity: 2, price: 50 },
      { productId: 2, quantity: 1, price: 30 },
    ],
  },
  {
    id: 2,
    items: [
      { productId: 1, quantity: 1, price: 50 },
      { productId: 3, quantity: 1, price: 100 },
    ],
  },
];

const totalRevenue = orders.reduce((acc, order) => {
  const orderTotal = order.items.reduce((total, item) => total + item.quantity, 0);
  return acc + orderTotal;
}, 0);

console.log('totalRevenue', totalRevenue);
