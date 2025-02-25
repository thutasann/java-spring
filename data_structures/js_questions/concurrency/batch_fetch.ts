async function fetchUsersBatch(batch: number[]): Promise<string[]> {
  return new Promise<string[]>((resolve) => {
    setTimeout(() => {
      resolve(batch.map((id) => `User ${id}`));
    }, 2000);
  });
}

async function batchFetchUsers(totalUsers: number, batchSize: number) {
  const message = 'Batch Fetching Time';
  console.time(message);

  const userIds = Array.from({ length: totalUsers }, (_, i) => i + 1);
  const batches: number[][] = [];

  for (let i = 0; i < userIds.length; i++) {
    batches.push(userIds.slice(i, i + batchSize));
  }

  const allResults = await Promise.all(batches.map((batch) => fetchUsersBatch(batch)));
  console.log(allResults.flat());
  console.timeEnd(message);
}
batchFetchUsers(10, 2);
