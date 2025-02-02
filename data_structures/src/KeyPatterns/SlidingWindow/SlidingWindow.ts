class SlidingWindow {
  examples() {
    this.maxSumOptimized();
  }

  maxSumOptimized() {
    console.log('\nMax Sum Optimized ==> ');
    const arr = [1, 4, 2, 10, 2, 3, 1, 0, 20];
    const k = 4;
    const n = arr.length;

    if (n <= k) {
      console.log('Invalid');
    }

    let maxSum = 0;
    for (let i = 0; i < k; i++) {
      maxSum += arr[i];
    }

    let windowSum = maxSum;
    for (let i = k; i < n; i++) {
      windowSum += arr[i] - arr[i - k];
      maxSum = Math.max(maxSum, windowSum);
    }

    console.log('maxSum ==> ', maxSum);
  }
}

const slidingWindow = new SlidingWindow();
slidingWindow.examples();
