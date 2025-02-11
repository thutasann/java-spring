type FetchOptions = {
  retries: number;
  retryDelay: number;
  onRetry?: (attempt: number, error: any) => void;
};

async function fetchWithRetries(
  url: string,
  options: RequestInit = {},
  fetchOptions: FetchOptions = {
    retries: 3,
    retryDelay: 1000,
  }
): Promise<Response> {
  let attempt = 0;
  let lastError: any;
  const { retries, retryDelay, onRetry } = fetchOptions;

  while (attempt < retries) {
    try {
      const response = await fetch(url, options);
      if (!response.ok) {
        throw new Error(`Http error!, Status : ${response.status}`);
      }
      return response;
    } catch (error) {
      lastError = error;
      attempt++;
      if (onRetry) onRetry(attempt, lastError);
      if (attempt < retries) {
        await new Promise((resolve) => setTimeout(resolve, retryDelay));
      }
    }
  }

  throw lastError;
}
