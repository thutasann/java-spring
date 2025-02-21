function debounce<T extends (...args: any[]) => void>(func: T, delay: number): T {
  let timeout: any;

  return function (...args: Parameters<T>) {
    clearTimeout(timeout);
    timeout = setTimeout(() => func(...args), delay);
  } as T;
}

const logDebounced = debounce(() => console.log('Debounced Call'), 500);
logDebounced();
logDebounced();
logDebounced();
