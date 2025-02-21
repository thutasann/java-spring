/**
 * Generic HashMap Implementation
 * @template K - Type of the keys
 * @template V - Type of the values
 */
export class HashMap<K, V> {
  private buckets: Array<[K, V][]>;
  private capacity: number;
  private size: number;
  private loadFactor: number;

  /**
   * a new HashMap instance.
   * @param capacity - Initial capacity of the hashmap
   * @param loadFactor - Load factor threshold for resizing.
   */
  constructor(capacity: number = 16, loadFactor: number = 0.75) {
    this.capacity = capacity;
    this.loadFactor = loadFactor;
    this.size = 0;
    this.buckets = new Array(capacity).fill(null).map(() => []);
  }

  /**
   * Generate a ahsh index for a given key.
   * @private
   * @param key - The key to hash
   * @returns - The computed hash index.
   */
  private hash(key: K): number {
    let hash = 0;
    const strKey = String(key);
    for (let i = 0; i < strKey.length; i++) {
      hash = (hash * 31 + strKey.charCodeAt(i)) % this.capacity;
    }
    return hash;
  }

  /**
   * Resize the hashmap when the load factor exceeds the threshold
   * @private
   */
  private resize(): void {
    if (this.size / this.capacity > this.loadFactor) {
      const oldBuckets = this.buckets;
      this.capacity *= 2;
      this.buckets = new Array(this.capacity).fill(null).map(() => []);
      this.size = 0;
      for (const bucket of oldBuckets) {
        for (const [key, value] of bucket) {
          this.put(key, value);
        }
      }
    }
  }

  /**
   * Inserts or updates a key-value pair in the hashmap.
   * @param key - The key to insert.
   * @param value - The value to associate with the key.
   */
  put(key: K, value: V): void {
    this.resize();
    const index = this.hash(key);
    const bucket = this.buckets[index];
    for (const entry of bucket) {
      if (entry[0] === key) {
        entry[1] = value;
        return;
      }
    }
    bucket.push([key, value]);
    this.size++;
  }

  /**
   * Retrieve the value associated with a key
   * @param key - the key to look up.
   * @returns the associated value or undefined if not found
   */
  get(key: K): V | undefined {
    const index = this.hash(key);
    const bucket = this.buckets[index];
    for (const entry of bucket) {
      if (entry[0] === key) {
        return entry[1];
      }
    }
    return undefined;
  }

  /**
   * Removes a key-value pair from the hashmap
   * @param key - the key to remove
   */
  remove(key: K): boolean {
    const index = this.hash(key);
    const bucket = this.buckets[index];
    for (let i = 0; i < bucket.length; i++) {
      if (bucket[i][0] === key) {
        bucket.splice(i, 1);
        this.size--;
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if a key exists in the hashmap
   * @param key - the key to check.
   */
  containsKey(key: K): boolean {
    return this.get(key) !== undefined;
  }

  /**
   * Checks if a value exists in the hashmap
   * @param value - the value to check
   */
  containsValue(value: V): boolean {
    return this.buckets.some((bucket) => bucket.some((entry) => entry[1] === value));
  }

  /**
   * Returns all keys in the hashmap
   */
  keys(): K[] {
    return this.buckets.flat().map((entry) => entry[0]);
  }

  /**
   * Returns all values in the hashmap
   */
  values(): V[] {
    return this.buckets.flat().map((entry) => entry[1]);
  }

  /**
   * Returns all key-value pairs in the hashmap
   */
  entries(): [K, V][] {
    return this.buckets.flat();
  }

  /**
   * Clears all key-value pairs from the hashmap
   */
  clear(): void {
    this.buckets = new Array(this.capacity).fill(null).map(() => []);
    this.size = 0;
  }

  /**
   * Returns the number of key-value pairs in the hashmap.
   */
  getSize(): number {
    return this.size;
  }
}
