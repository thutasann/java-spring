import { HashMap } from './hashmap';

type User = {
  id: number;
  name: string;
};

function fetchUsers(): Promise<User[]> {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve([
        { id: 1, name: 'Alice' },
        { id: 2, name: 'Bob' },
        { id: 3, name: 'Charlie' },
      ]);
    }, 500);
  });
}

const userCache = new HashMap<number, User>();

function cacheUser(user: User) {
  userCache.put(user.id, user);
}

function getUserFromCache(userId: number) {
  return userCache.get(userId);
}

function isUserCached(userId: number) {
  return userCache.containsKey(userId);
}

async function main() {
  const users = await fetchUsers();

  cacheUser(users[0]);
  cacheUser(users[1]);

  console.log(getUserFromCache(1)); // { id: 1, name: "Alice" }
  console.log(isUserCached(3)); // false
}
main();
