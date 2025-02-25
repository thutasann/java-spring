async function fetchUsers() {
  return new Promise<string>((resolve) => setTimeout(() => resolve('User Data'), 2000));
}

async function fetchPosts() {
  return new Promise<string>((resolve) => setTimeout(() => resolve('Product Data'), 3000));
}

/**
 * Sequential Time: 5005.678ms
 * Total Time: 5 seconds (because each await waits for the previous one to finish).
 */
async function fetchDataSequentital() {
  const message = 'Sequential time';
  console.time(message);

  const users = await fetchUsers();
  const posts = await fetchPosts();

  console.log({ users, posts });
  console.timeEnd(message);
}

/**
 * Parallel Time: 3002.456ms
 * - Total Time: 3 seconds (instead of 5s)!
 * - ✅ Use Promise.all() whenever tasks are independent and can run in parallel.
 * - ✅ It makes execution faster than multiple sequential await calls! 🚀
 */
async function fetchDataParallel() {
  const message = 'Parallel Time';
  console.time(message);

  const [user, posts] = await Promise.all([fetchUsers(), fetchPosts()]);

  console.log({ user, posts });
  console.timeEnd(message);
}
fetchDataParallel();
