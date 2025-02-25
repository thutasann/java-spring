const processImage = (image: string) => {
  return new Promise<string>((resolve) => {
    setTimeout(() => {
      console.log(`Processes ${image}`);
      resolve(image);
    }, 1000);
  });
};

async function ProcessImagesConcurrently(images: string[], maxConcurrent: number) {
  const results: string[] = [];
  const queue: Promise<number>[] = [];

  for (let i = 0; i < images.length; i++) {
    const currentImage = images[i];

    const task = processImage(currentImage).then((result) => results.push(result));
    queue.push(task);

    if (queue.length >= maxConcurrent) {
      await Promise.race(queue);
    }
  }

  await Promise.all(queue);

  console.log('all images processed : ', results);
}
ProcessImagesConcurrently(['image1', 'image2', 'image3', 'image4', 'image5'], 3);
